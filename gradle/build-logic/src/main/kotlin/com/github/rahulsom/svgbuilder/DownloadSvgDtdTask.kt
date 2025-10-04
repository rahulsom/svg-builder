package com.github.rahulsom.svgbuilder

import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.*
import java.net.URI
import javax.inject.Inject

@CacheableTask
abstract class DownloadSvgDtdTask @Inject constructor() : DefaultTask() {

    @get:OutputDirectory
    abstract val schemasDir: DirectoryProperty

    @get:Input
    val dtdUrl = "https://www.w3.org/Graphics/SVG/1.1/DTD/svg11-flat-20030114.dtd"

    @get:OutputFile
    val dtdFile get() = schemasDir.file("svg.dtd").get().asFile

    @get:OutputFile
    val xsdFile get() = schemasDir.file("svg.xsd").get().asFile

    @TaskAction
    fun downloadAndConvert() {
        val schemasDirectory = schemasDir.get().asFile
        schemasDirectory.mkdirs()

        if (!dtdFile.exists()) {
            dtdFile.writeText(URI(dtdUrl).toURL().readText())
        }

        // Convert DTD to XSD
        val converter = Converter()
        converter.convert(schemasDirectory.parentFile)
    }
}