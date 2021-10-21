package com.example.gradle_plugin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project

class TracePlugin implements Plugin<Project> {
    void apply(Project project) {
        println "------------- TracePlugin apply --------------"
        project.extensions.create("traceConfig", TraceExtension)
        project.plugins.findAll {
            switch (it) {
                case LibraryPlugin:
                    def android = project.extensions.getByType(LibraryExtension)
                    android.registerTransform(new TraceMethodTransform(project))
                    break
                case AppPlugin:
                    def android = project.extensions.getByType(AppExtension)
                    android.registerTransform(new TraceMethodTransform(project))
                    break
            }
        }

    }
}
