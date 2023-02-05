group = "deltadak"
version = "0.0"

plugins {

    val kotlinVersion = "1.8.0"

    application
    kotlin("jvm") version kotlinVersion
    java // Required by at least JUnit.

    // Plugin which checks for dependency updates with help/dependencyUpdates task.
    id("com.github.ben-manes.versions") version "0.45.0"

    // Plugin which can update Gradle dependencies, use help/useLatestVersions
    id("se.patrikerdes.use-latest-versions") version "0.2.18"

    // Kotest (previously KotlinTest)
    id("io.kotest.multiplatform") version "5.5.4"

    // Test coverage
    jacoco

    // Upload jacoco coverage reports to coveralls
    id("com.github.nbaztec.coveralls-jacoco") version "1.2.15"

    // New test coverage plugin
    id("org.jetbrains.kotlinx.kover") version "0.7.0-ALPHA"

    // https://openjfx.io/openjfx-docs/#gradle
    id("org.openjfx.javafxplugin") version "0.0.13"

    // Linting
    id("org.jlleitschuh.gradle.ktlint") version "11.1.0"
}

javafx {
    version = "14"
    modules = listOf("javafx.controls")
}

dependencies {
    // To "prevent strange errors".
    implementation(kotlin("stdlib"))
    // Kotlin reflection.
    implementation(kotlin("reflect"))

//    implementation(kotlin("test"))
//    implementation(kotlin("test-junit"))

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    testRuntimeOnly("org.junit.platform:junit-platform-console:1.9.2")

    // Kotlintest
    implementation("io.kotest:kotest-framework-engine:5.5.4")
    implementation("io.kotest:kotest-assertions-core:5.5.4")
    implementation("io.kotest:kotest-framework-engine-jvm:5.5.4")
    implementation("io.kotest:kotest-runner-junit5-jvm:5.5.4")

    // JavaFX tests using TestFX
    testImplementation("org.testfx:testfx-core:4.0.16-alpha")
    testImplementation("org.testfx:testfx-junit:4.0.15-alpha")
    // Only needed for headless testing.
//    testImplementation("org.testfx:openjfx-monocle:8u76-b04") // jdk-9+181 for Java 9

    // Spek
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:2.0.19")
    testImplementation("org.spekframework.spek2:spek-runner-junit5:2.0.19")
}

repositories {
    mavenCentral()
    mavenLocal()
}

// Test coverage reporting for coveralls.
tasks.jacocoTestReport {
    // Enable xml for coveralls.
    reports {
        // To be read by humans
        html.required.set(true)
        // To be read by Coveralls etc.
        xml.required.set(true)
        xml.outputLocation.set(file("$buildDir/reports/jacoco/test/jacocoTestReport.xml"))
    }
}

tasks.test {
    // Use the built-in JUnit support of Gradle.
    useJUnitPlatform()

    // Always run tests even if nothing changed, for demonstration purposes
    dependsOn("cleanTest")
}
