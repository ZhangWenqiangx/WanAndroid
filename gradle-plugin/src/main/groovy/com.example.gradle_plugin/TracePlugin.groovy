package com.example.gradle_plugin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import com.example.gradle_plugin.legalBitmap.LegalBitmapConfig
import com.example.gradle_plugin.legalBitmap.TraceImageTransform
import org.gradle.api.Plugin
import org.gradle.api.Project

class TracePlugin implements Plugin<Project> {
    void apply(Project project) {
        println "------------- TracePlugin apply --------------"
        project.extensions.create("traceConfig", TraceExtension)
        project.plugins.findAll {
            switch (it) {
                case LibraryPlugin:
                    def appExtension = project.extensions.getByType(LibraryExtension)
                    appExtension.registerTransform(new TraceMethodTransform(project))
                    appExtension.registerTransform(new TraceImageTransform(project))
                    break
                case AppPlugin:
                    def appExtension = project.extensions.getByType(AppExtension)
                    appExtension.registerTransform(new TraceMethodTransform(project))
                    appExtension.registerTransform(new TraceImageTransform(project))
                    break
            }
        }

    }
}
