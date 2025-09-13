plugins {
    `kotlin-dsl`
}

group = "com.github.rahulsom.svg-builder.build-logic"

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("svg-builder") {
            id = "com.github.rahulsom.svg-builder"
            implementationClass = "com.github.rahulsom.svgbuilder.SvgBuilderPlugin"
        }
    }
}

dependencies {
    implementation(libs.trang)
}