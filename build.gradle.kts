import com.github.rahulsom.waena.WaenaExtension

plugins {
    id("com.github.rahulsom.svg-builder")
    id("java")
    id("groovy")
    id("org.jetbrains.kotlin.jvm") version "2.2.20"
    id("com.github.rahulsom.waena.root") version "0.18.0"
    id("com.github.rahulsom.waena.published") version "0.18.0"
}

contacts {
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
