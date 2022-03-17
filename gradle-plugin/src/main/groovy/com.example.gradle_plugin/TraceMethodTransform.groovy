package com.example.gradle_plugin

import com.android.build.api.transform.*
import com.android.build.gradle.internal.pipeline.TransformManager
import com.example.gradle_plugin.trace.Config
import com.example.gradle_plugin.trace.MethodTracer
import org.gradle.api.Project

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

            def methodTracer = new MethodTracer(config)
            transformInputs.each { input ->
                methodTracer.trace(input, outputProvider)
            }
        }
    }

    Config initConfig() {
        def configuration = project.traceConfig
        Config config = new Config()
        config.MIsNeedLogTraceInfo = configuration.logTraceInfo
        config.MTraceConfigFile = configuration.traceConfigFile
        return config
    }

    @Override
    String getName() {
        return "TraceMethodTransform"
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