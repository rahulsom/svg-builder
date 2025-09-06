import com.github.rahulsom.svgbuilder.Converter
import com.github.rahulsom.svgbuilder.GroovyNewifyBuilder
import com.github.rahulsom.waena.WaenaExtension
import java.net.URI

plugins {
    id("java")
    id("groovy")
    id("org.jetbrains.kotlin.jvm") version "2.2.10"
    id("com.github.rahulsom.waena.root") version "0.17.0"
    id("com.github.rahulsom.waena.published") version "0.17.0"
}

configure<nebula.plugin.contacts.ContactsExtension> {
  validateEmails = true
  addPerson("rahulsom@noreply.github.com", delegateClosureOf<nebula.plugin.contacts.Contact> {
    moniker("Rahul Somasunderam")
    roles("owner")
    github("https://github.com/rahulsom")
  })
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
    xjcTool("org.glassfish.jaxb:jaxb-xjc:4.0.5")
    xjcTool("org.glassfish.jaxb:jaxb-runtime:4.0.5")
    xjcTool("jakarta.xml.bind:jakarta.xml.bind-api:4.0.2")
    xjcTool("javax.xml.bind:jaxb-api:2.3.1")
    xjcTool("org.jvnet.jaxb2_commons:jaxb2-fluent-api:3.0")
    xjcTool("org.jvnet.jaxb2_commons:jaxb2-basics-annotate:1.1.0")

    compileOnly("org.codehaus.groovy:groovy-all:3.0.25")

    implementation("jakarta.xml.bind:jakarta.xml.bind-api:4.0.2")
    implementation("org.glassfish.jaxb:jaxb-runtime:4.0.5")
    implementation("com.sun.xml.bind:jaxb-core:4.0.5")

    testImplementation("org.spockframework:spock-core:2.3-groovy-4.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

tasks.register("download") {
    doFirst {
        if (!file("build/schemas/svg.dtd").exists()) {
            file("${layout.buildDirectory.get()}/schemas").mkdirs()
            file("build/schemas/svg.dtd").writeText(
                URI("https://www.w3.org/Graphics/SVG/1.1/DTD/svg11-flat-20030114.dtd").toURL().readText()
            )
        }
        Converter().convert(layout.buildDirectory.get().asFile)
    }
}

tasks.register<JavaExec>("xjcGenerate") {
    description = "Generate Java classes from XML schema"
    group = "build"

    dependsOn("download")

    classpath = xjcTool
    mainClass.set("com.sun.tools.xjc.Driver")

    val outputDir = file("build/generated/sources/xjc/java/main")
    val schemaDir = file("build/schemas")
    val bindingDir = file("src/main/jaxb")

    inputs.dir(schemaDir).withPropertyName("schemaDir")
    inputs.dir(bindingDir).withPropertyName("bindingDir").optional()
    outputs.dir(outputDir)

    args = listOf(
        "-d", outputDir.absolutePath,
        "-quiet",
        "-extension",
        "-Xfluent-api",
        "-Xannotate"
    ) + (if (bindingDir.exists()) listOf("-b", bindingDir.absolutePath) else emptyList()) +
    listOf(schemaDir.absolutePath)

    doFirst {
        outputDir.mkdirs()
    }

    doLast {
        GroovyNewifyBuilder().createFile(layout.buildDirectory.get().asFile)
    }
}

tasks.compileJava {
    dependsOn("xjcGenerate")
}

tasks.compileKotlin {
    dependsOn("xjcGenerate")
}

tasks.named("sourcesJar") {
    dependsOn("xjcGenerate")
}

tasks.compileTestGroovy {
    doFirst {
        copy {
            from("build/classes/kotlin/test")
            into("build/classes/java/test")
        }
    }
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

configure<WaenaExtension> {
    publishMode.set(WaenaExtension.PublishMode.Central)
}
