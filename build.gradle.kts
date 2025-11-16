plugins {
    alias(libs.plugins.svg.builder)
    id("java")
    id("groovy")
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.waena.root)
    alias(libs.plugins.waena.published)
}

contacts {
  validateEmails = true
  with(addPerson("rahulsom@noreply.github.com")) {
    moniker("Rahul Somasunderam")
    roles("owner")
    github("https://github.com/rahulsom")
  }
}

group = "com.github.rahulsom"
description = "A library for building SVG diagrams"

repositories {
    mavenCentral()
}

sourceSets {
    main {
        groovy.srcDir("build/groovysupport/generated-sources")
        java.srcDir("build/generated/sources/xjc/java/main")
    }
}

val xjcTool by configurations.creating

dependencies {
    xjcTool(libs.bundles.xjc.tools)

    compileOnly(libs.groovy.all)

    implementation(libs.bundles.jaxb.runtime)

    testImplementation(libs.groovy.all)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.assertj.core)
    testRuntimeOnly(libs.junit.platform.launcher)
    testImplementation(libs.kotlin.stdlib.jdk8)
    compileOnly(libs.kotlin.stdlib.jdk8)
}

tasks.downloadSvgDtd.configure {
    schemasDir.set(layout.buildDirectory.dir("schemas"))
}

tasks.generateXjc.configure {
    dependsOn(tasks.downloadSvgDtd)
    schemaDir.set(layout.buildDirectory.dir("schemas"))
    bindingDir.set(layout.projectDirectory.dir("src/main/jaxb"))
    outputDir.set(layout.buildDirectory.dir("generated/sources/xjc/java/main"))
    xjcClasspath.setFrom(xjcTool)
    buildDir.set(layout.buildDirectory)
}

tasks.compileJava {
    dependsOn(tasks.generateXjc)
}

tasks.compileKotlin {
    dependsOn(tasks.generateXjc)
}

tasks.named("sourcesJar") {
    dependsOn(tasks.generateXjc)
}

tasks.copyKotlinTestClasses.configure {
    dependsOn(tasks.compileTestKotlin)
    kotlinTestClassesDir.set(layout.buildDirectory.dir("classes/kotlin/test"))
    javaTestClassesDir.set(layout.buildDirectory.dir("classes/java/test"))
}

tasks.compileTestGroovy {
    dependsOn(tasks.copyKotlinTestClasses)
}

tasks.javadoc {
    (options as StandardJavadocDocletOptions).addStringOption("Xdoclint:none", "-quiet")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
