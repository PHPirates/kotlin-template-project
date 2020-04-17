group = "deltadak"
version = "0.0"

plugins {

    val kotlinVersion = "1.3.60"

    application
    kotlin("jvm") version kotlinVersion
    java // Required by at least JUnit.

    // Plugin which checks for dependency updates with help/dependencyUpdates task.
    id("com.github.ben-manes.versions") version "0.28.0"

    // Plugin which can update Gradle dependencies, use help/useLatestVersions
    id("se.patrikerdes.use-latest-versions") version "0.2.13"

    // Test coverage
    jacoco

    // Upload jacoco coverage reports to coveralls
    id("com.github.kt3k.coveralls") version "2.10.1"
}

application {
    mainClassName = "deltadak.HelloWorld"
}

dependencies {
    implementation(kotlin("stdlib"))
    // To "prevent strange errors".
    implementation(kotlin("reflect"))
    // Kotlin reflection.
    implementation(kotlin("test"))
    implementation(kotlin("test-junit"))

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
    testRuntimeOnly("org.junit.platform:junit-platform-console:1.6.2")

    // Kotlintest
    testImplementation("io.kotlintest:kotlintest-core:3.4.2")
    testImplementation("io.kotlintest:kotlintest-assertions:3.4.2")
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")

    // JavaFX tests using TestFX
    testImplementation("org.testfx:testfx-core:4.0.16-alpha")
    testImplementation("org.testfx:testfx-junit:4.0.16-alpha")
    // Only needed for headless testing.
//    testImplementation("org.testfx:openjfx-monocle:8u76-b04") // jdk-9+181 for Java 9

    // Spek
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:2.0.10")
    testImplementation("org.spekframework.spek2:spek-runner-junit5:2.0.10")
}

repositories {
    mavenCentral()
    mavenLocal()
    jcenter()
}

// Test coverage reporting for coveralls.
tasks {
    // Enable xml for coveralls.
    "jacocoTestReport"(JacocoReport::class) {
        reports {
            // To be read by humans
            html.isEnabled = true
            // To be read by Coveralls etc.
            xml.isEnabled = true
            xml.destination = file("$buildDir/reports/jacoco/test/jacocoTestReport.xml")
        }

    }

    // Trying to run tests every time.
    val test by tasks
    val cleanTest by tasks
    test.dependsOn(cleanTest)

    // Use the built-in JUnit support of Gradle.
    "test"(Test::class) {
        useJUnitPlatform()
    }

    // Sorry, I have no idea.
    Unit
}
