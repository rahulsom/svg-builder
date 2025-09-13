package com.github.rahulsom.svgbuilder

import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.FileSystemOperations
import org.gradle.api.tasks.*
import javax.inject.Inject

@CacheableTask
abstract class CopyKotlinTestClassesTask @Inject constructor(
    private val fileSystemOperations: FileSystemOperations
) : DefaultTask() {

    @get:InputDirectory
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val kotlinTestClassesDir: DirectoryProperty

    @get:OutputDirectory
    abstract val javaTestClassesDir: DirectoryProperty

    @TaskAction
    fun copyClasses() {
        fileSystemOperations.copy {
            from(kotlinTestClassesDir)
            into(javaTestClassesDir)
        }
    }
}