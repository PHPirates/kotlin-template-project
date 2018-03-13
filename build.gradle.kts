import org.junit.platform.gradle.plugin.JUnitPlatformExtension

group = "deltadak"
version = "0.0"

// Latest version as of 2018-03-13: JUnit 5.1.0 = Platform 1.1.0 + Jupiter 5.1.0 + Vintage 5.1.0

// JUnit 5
buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.1.0")
    }
}

apply {
    plugin("org.junit.platform.gradle.plugin")
}

//extensions.getByType(JUnitPlatformExtension::class.java).apply {
//    filters {
//        engines {
//            include("junit-jupiter")
//        }
//    }
//}

// Kotlin configuration.
plugins {
    application
    kotlin("jvm") version "1.2.30"
    java
}

application {
    mainClassName = "deltadak.HelloWorld"
}

dependencies {
    compile(kotlin("stdlib"))
    // To "prevent strange errors".
    compile(kotlin("reflect"))

    // Built-in Kotlin test framework.
    testCompile("io.kotlintest:kotlintest:2.0.7")

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.1.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.1.0")
    testRuntime("org.junit.platform:junit-platform-console:1.1.0")

    // Kotlintests are not run anyway when using JUnit 5 as well.
    testCompile("io.kotlintest:kotlintest:2.0.7")

    // JavaFX tests using TestFX
    testCompile("org.testfx:testfx-core:4.0.12-alpha")
    testCompile("org.testfx:testfx-junit:4.0.12-alpha")
    // Only needed for headless testing.
//    testCompile("org.testfx:openjfx-monocle:8u76-b04") // jdk-9+181 for Java 9
}

repositories {
    jcenter()
}
