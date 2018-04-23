import org.gradle.api.plugins.ExtensionAware

import org.junit.platform.gradle.plugin.FiltersExtension
import org.junit.platform.gradle.plugin.EnginesExtension
import org.junit.platform.gradle.plugin.JUnitPlatformExtension

group = "deltadak"
version = "0.0"

// Latest version as of 2018-03-13: JUnit 5.1.0 = Platform 1.1.0 + Jupiter 5.1.0 + Vintage 5.1.0

// JUnit 5
buildscript {
    repositories {
        maven { url = uri("https://dl.bintray.com/jetbrains/spek") }
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.2.0-RC1")
    }
}

apply {
    plugin("org.junit.platform.gradle.plugin")
}

// Kotlin configuration.
plugins {

    val kotlinVersion = "1.2.31"

    application
    kotlin("jvm") version kotlinVersion
    java // Required by at least JUnit.
    // Plugin which checks for dependency updates with help/dependencyUpdates task.
    id("com.github.ben-manes.versions") version "0.17.0"
    // Plugin which can update Gradle dependencies, use help/useLatestVersions
    id("se.patrikerdes.use-latest-versions") version "0.2.1"
}

application {
    mainClassName = "deltadak.HelloWorld"
}

dependencies {
    compile(kotlin("stdlib"))
    // To "prevent strange errors".
    compile(kotlin("reflect"))
    // Kotlin reflection.
    compile(kotlin("test"))
    compile(kotlin("test-junit"))

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.2.0-RC1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.2.0-RC1")
    testRuntime("org.junit.platform:junit-platform-console:1.2.0-RC1")

    // Kotlintests are not run anyway when using JUnit 5 as well.
    testCompile("io.kotlintest:kotlintest-core:3.1.0-RC1")
    testCompile("io.kotlintest:kotlintest-assertions:3.1.0-RC1")
    testCompile("io.kotlintest:kotlintest-runner-junit5:3.1.0-RC1")

    // JavaFX tests using TestFX
    testCompile("org.testfx:testfx-core:4.0.13-alpha")
    testCompile("org.testfx:testfx-junit:4.0.13-alpha")
    // Only needed for headless testing.
//    testCompile("org.testfx:openjfx-monocle:8u76-b04") // jdk-9+181 for Java 9

    // Spek
    testCompile("org.jetbrains.spek:spek-api:1.1.19")
    testRuntime("org.jetbrains.spek:spek-junit-platform-engine:1.1.5")
}

repositories {
    maven { url = uri("https://dl.bintray.com/jetbrains/spek") }
    mavenCentral()
    jcenter()
}
