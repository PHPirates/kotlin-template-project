group = "deltadak"
version = "0.0"

plugins {

    val kotlinVersion = "1.8.20"

    application
    kotlin("jvm") version kotlinVersion
    java // Required by at least JUnit.

    // Plugin which checks for dependency updates with help/dependencyUpdates task.
    id("com.github.ben-manes.versions") version "0.46.0"

    // Plugin which can update Gradle dependencies, use help/useLatestVersions
    id("se.patrikerdes.use-latest-versions") version "0.2.18"

    // Kotest (previously KotlinTest)
    id("io.kotest.multiplatform") version "5.6.1"

    // Test coverage
    jacoco

    // Upload jacoco coverage reports to coveralls
    id("com.github.nbaztec.coveralls-jacoco") version "1.2.15"

    // New test coverage plugin
    id("org.jetbrains.kotlinx.kover") version "0.7.0-Beta"

    // Linting
    id("org.jlleitschuh.gradle.ktlint") version "11.3.2"
}

dependencies {
    // To "prevent strange errors".
    implementation(kotlin("stdlib"))
    // Kotlin reflection.
    implementation(kotlin("reflect"))

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.3")
    testRuntimeOnly("org.junit.platform:junit-platform-console:1.9.3")

    // Kotlintest
    implementation("io.kotest:kotest-framework-engine:5.6.1")
    implementation("io.kotest:kotest-assertions-core:5.6.1")
    implementation("io.kotest:kotest-framework-engine-jvm:5.6.1")
    implementation("io.kotest:kotest-runner-junit5-jvm:5.6.1")

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

// https://github.com/ben-manes/gradle-versions-plugin
fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

tasks.dependencyUpdates {
    rejectVersionIf {
        isNonStable(candidate.version)
    }
}
