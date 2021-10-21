package com.example.gradle_plugin;

import org.apache.http.util.TextUtils;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * author : zhang.wenqiang
 * date : 2021/10/13
 * description :
 */
public class TraceClassVisitor extends ClassVisitor {

    private String className = "";
    private boolean isAbsClass;
    private boolean isBeatClass;
    private boolean isConfigTraceClass;
    private Config traceConfig;

    private int api;
    private ClassVisitor cv;

    public TraceClassVisitor(int api, ClassVisitor cv, Config traceConfig) {
        super(api, cv);
        this.api = api;
        this.cv = cv;
        this.traceConfig = traceConfig;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        this.className = name;
        String resultClassName = name.replace(".", "/");
        //beat class
        if (resultClassName.equals(traceConfig.getMBeatClass())) {
            this.isBeatClass = true;
        }
        //config ingore class
        if (!TextUtils.isEmpty(name)) {
            isConfigTraceClass = traceConfig.isConfigTraceClass(className);
        }
        //abs/interface
        if (access == Opcodes.ACC_ABSTRACT || access == Opcodes.ACC_INTERFACE) {
            this.isAbsClass = true;
        }

        boolean isNotNeedTraceClass = isAbsClass || isBeatClass || !isConfigTraceClass;
        if (traceConfig.getMIsNeedLogTraceInfo() && !isNotNeedTraceClass) {
            System.out.println("MethodTrace-trace-class:" + className);
        }
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (isConstructor(name) || !isConfigTraceClass || isAbsClass || isBeatClass) {
            return super.visitMethod(access, name, desc, signature, exceptions);
        } else {
            MethodVisitor visitor = cv.visitMethod(access, name, desc, signature, exceptions);
            
            return new TraceMethodVisitor(api, visitor, access, name, desc, className, traceConfig);
        }
    }

    private boolean isConstructor(String name) {
        return name.contains("<init>");
    }
}
