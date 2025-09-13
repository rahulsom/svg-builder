package com.github.rahulsom.svgbuilder

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import javax.inject.Inject

open class SvgBuilderExtension @Inject constructor(objects: ObjectFactory) {
    val converter = objects.newInstance(Converter::class.java)
    val groovyNewifyBuilder = objects.newInstance(GroovyNewifyBuilder::class.java)
}

class SvgBuilderPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.create("svgBuilderPlugin", SvgBuilderExtension::class.java)

        // Register custom task types for configuration cache compatibility
        project.tasks.register("downloadSvgDtd", DownloadSvgDtdTask::class.java)
        project.tasks.register("generateXjc", GenerateXjcTask::class.java)
        project.tasks.register("copyKotlinTestClasses", CopyKotlinTestClassesTask::class.java)
    }
}
