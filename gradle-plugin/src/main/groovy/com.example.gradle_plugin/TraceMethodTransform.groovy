package com.example.gradle_plugin

import com.android.build.api.transform.*
import com.android.build.gradle.internal.pipeline.TransformManager
import org.apache.commons.codec.digest.DigestUtils
import org.apache.commons.io.FileUtils
import org.apache.commons.io.IOUtils
import org.gradle.api.Project
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes

import java.util.jar.JarEntry
import java.util.jar.JarFile
import java.util.jar.JarOutputStream
import java.util.zip.ZipEntry

import static org.objectweb.asm.ClassReader.EXPAND_FRAMES

/**
 * Transform
 */
class TraceMethodTransform extends Transform {

    private Project project

    TraceMethodTransform(Project project) {
        this.project = project
    }

    @Override
    void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
        def traceConfig = project.traceConfig
        String output = traceConfig.output
        if (output == null || output.isEmpty()) {
            traceConfig.output = project.getBuildDir().getAbsolutePath() + File.separator + "trace_output"
        }

        if (traceConfig.open) {
            Config config = initConfig()
            config.parseTraceConfigFile()

            def transformInputs = transformInvocation.inputs
            def outputProvider = transformInvocation.outputProvider
            if (outputProvider != null) {
                outputProvider.deleteAll()
            }

            transformInputs.each { input ->
                input.directoryInputs.each {
                    traceSrcFiles(it, outputProvider, config)
                }
                input.jarInputs.each { JarInput jarInput ->
                    traceJarFiles(jarInput, outputProvider, config)
                }
            }
        }
    }

    static void traceSrcFiles(DirectoryInput directoryInput, TransformOutputProvider outputProvider, Config traceConfig) {
        if (directoryInput.file.isDirectory()) {
            directoryInput.file.eachFileRecurse { File file ->
                def name = file.name
                if (traceConfig.isNeedTraceClass(name)) {
                    ClassReader classReader = new ClassReader(file.bytes)
                    ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS)
                    ClassVisitor cv = new TraceClassVisitor(Opcodes.ASM7, classWriter,traceConfig)
                    classReader.accept(cv, EXPAND_FRAMES)
                    byte[] code = classWriter.toByteArray()
                    FileOutputStream fos = new FileOutputStream(
                            file.parentFile.absolutePath + File.separator + name)
                    fos.write(code)
                    fos.close()
                }
            }
        }

        def dest = outputProvider.getContentLocation(directoryInput.name,
                directoryInput.contentTypes, directoryInput.scopes,
                Format.DIRECTORY)
        FileUtils.copyDirectory(directoryInput.file, dest)
    }

    static void traceJarFiles(JarInput jarInput, TransformOutputProvider outputProvider, Config traceConfig) {
        if (jarInput.file.getAbsolutePath().endsWith(".jar")) {
            //重命名输出文件,因为可能同名,会覆盖
            def jarName = jarInput.name
            def md5Name = DigestUtils.md5Hex(jarInput.file.getAbsolutePath())
            if (jarName.endsWith(".jar")) {
                jarName = jarName.substring(0, jarName.length() - 4)
            }
            JarFile jarFile = new JarFile(jarInput.file)
            Enumeration enumeration = jarFile.entries()

            File tmpFile = new File(jarInput.file.getParent() + File.separator + "classes_temp.jar")
            if (tmpFile.exists()) {
                tmpFile.delete()
            }

            JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(tmpFile))

            //循环jar包里的文件
            while (enumeration.hasMoreElements()) {
                JarEntry jarEntry = (JarEntry) enumeration.nextElement()
                String entryName = jarEntry.getName()
                ZipEntry zipEntry = new ZipEntry(entryName)
                InputStream inputStream = jarFile.getInputStream(jarEntry)
                if (traceConfig.isNeedTraceClass(entryName)) {
                    jarOutputStream.putNextEntry(zipEntry)
                    ClassReader classReader = new ClassReader(IOUtils.toByteArray(inputStream))
                    ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_MAXS)
                    ClassVisitor cv = new TraceClassVisitor(Opcodes.ASM7, classWriter,traceConfig)
                    classReader.accept(cv, EXPAND_FRAMES)
                    byte[] code = classWriter.toByteArray()
                    jarOutputStream.write(code)
                } else {
                    jarOutputStream.putNextEntry(zipEntry)
                    jarOutputStream.write(IOUtils.toByteArray(inputStream))
                }
                jarOutputStream.closeEntry()
            }

            jarOutputStream.close()
            jarFile.close()

            def dest = outputProvider.getContentLocation(jarName + md5Name,
                    jarInput.contentTypes, jarInput.scopes, Format.JAR)
            FileUtils.copyFile(tmpFile, dest)

            tmpFile.delete()
        }
    }

    Config initConfig() {
        def configuration = project.traceConfig
        Config config = new Config()
        config.MTraceConfigFile = configuration.traceConfigFile
        config.MIsNeedLogTraceInfo = configuration.logTraceInfo
        return config
    }

    @Override
    String getName() {
        return "traceMethodTransform"
    }

    @Override
    Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS
    }

    @Override
    Set<? super QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    @Override
    boolean isIncremental() {
        return true
    }
}