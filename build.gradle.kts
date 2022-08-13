group = "deltadak"
version = "0.0"

plugins {

    val kotlinVersion = "1.6.0"

    application
    kotlin("jvm") version kotlinVersion
    java // Required by at least JUnit.

    // Plugin which checks for dependency updates with help/dependencyUpdates task.
    id("com.github.ben-manes.versions") version "0.42.0"

    // Plugin which can update Gradle dependencies, use help/useLatestVersions
    id("se.patrikerdes.use-latest-versions") version "0.2.18"

    // Test coverage
    jacoco

    // Upload jacoco coverage reports to coveralls
    id("com.github.nbaztec.coveralls-jacoco") version "1.2.14"

    // New test coverage plugin
    id("org.jetbrains.kotlinx.kover") version "0.6.0-Beta"

    // https://openjfx.io/openjfx-docs/#gradle
    id("org.openjfx.javafxplugin") version "0.0.13"
}

javafx {
    version = "14"
    modules = listOf("javafx.controls")
}

dependencies {
    implementation(kotlin("stdlib"))
    // To "prevent strange errors".
    implementation(kotlin("reflect"))
    // Kotlin reflection.
    implementation(kotlin("test"))
    implementation(kotlin("test-junit"))

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
    testRuntimeOnly("org.junit.platform:junit-platform-console:1.9.0")

    // Kotlintest
    testImplementation("io.kotlintest:kotlintest-core:3.4.2")
    testImplementation("io.kotlintest:kotlintest-assertions:3.4.2")
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")

    // JavaFX tests using TestFX
    testImplementation("org.testfx:testfx-core:4.0.16-alpha")
    testImplementation("org.testfx:testfx-junit:4.0.15-alpha")
    // Only needed for headless testing.
//    testImplementation("org.testfx:openjfx-monocle:8u76-b04") // jdk-9+181 for Java 9

    // Spek
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:2.0.18")
    testImplementation("org.spekframework.spek2:spek-runner-junit5:2.0.18")
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
