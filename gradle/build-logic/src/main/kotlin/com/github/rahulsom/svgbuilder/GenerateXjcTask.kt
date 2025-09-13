package com.github.rahulsom.svgbuilder

import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.*
import org.gradle.process.JavaExecSpec
import java.io.File
import javax.inject.Inject

@CacheableTask
abstract class GenerateXjcTask @Inject constructor() : JavaExec() {

    @get:InputDirectory
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val schemaDir: DirectoryProperty

    @get:InputDirectory
    @get:Optional
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val bindingDir: DirectoryProperty

    @get:OutputDirectory
    abstract val outputDir: DirectoryProperty

    @get:Classpath
    abstract val xjcClasspath: ConfigurableFileCollection

    @get:Internal
    abstract val buildDir: DirectoryProperty

    init {
        group = "build"
        description = "Generate Java classes from XML schema"
        mainClass.set("com.sun.tools.xjc.Driver")
    }

    @TaskAction
    override fun exec() {
        classpath = xjcClasspath

        val outputDirectory = outputDir.get().asFile
        outputDirectory.mkdirs()

        val schemas = schemaDir.get().asFile
        val bindings = bindingDir.get().asFile

        args = buildList {
            addAll(listOf("-d", outputDirectory.absolutePath))
            add("-quiet")
            add("-extension")
            add("-Xfluent-api")
            add("-Xannotate")
            if (bindings.exists()) {
                addAll(listOf("-b", bindings.absolutePath))
            }
            add(schemas.absolutePath)
        }

        super.exec()

        // Generate groovy newify file
        val groovyBuilder = GroovyNewifyBuilder()
        groovyBuilder.createFile(buildDir.get().asFile)
    }
}