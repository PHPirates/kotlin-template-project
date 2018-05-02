group = "deltadak"
version = "0.0"

// Latest version as of 2018-03-13: JUnit 5.1.0 = Platform 1.1.0 + Jupiter 5.1.0 + Vintage 5.1.0

// Spek still requirest the buildscript block because of maven issues.
buildscript {
    repositories {
        maven { url = uri("https://dl.bintray.com/jetbrains/spek") }
        mavenCentral()
        jcenter()
    }
}

plugins {

    val kotlinVersion = "1.2.41"

    application
    kotlin("jvm") version kotlinVersion
    java // Required by at least JUnit.

    // Plugin which checks for dependency updates with help/dependencyUpdates task.
    id("com.github.ben-manes.versions") version "0.17.0"

    // Plugin which can update Gradle dependencies, use help/useLatestVersions
    id("se.patrikerdes.use-latest-versions") version "0.2.1"

    // Test coverage
    jacoco

    // Upload jacoco coverage reports to coveralls
    id("com.github.kt3k.coveralls") version "2.8.2"
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
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.2.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.2.0")
    testRuntime("org.junit.platform:junit-platform-console:1.2.0")

    // Kotlintest
    testCompile("io.kotlintest:kotlintest-core:3.1.0-RC2")
    testCompile("io.kotlintest:kotlintest-assertions:3.1.0-RC2")
    testCompile("io.kotlintest:kotlintest-runner-junit5:3.1.0-RC2")

    // JavaFX tests using TestFX
    testCompile("org.testfx:testfx-core:4.0.13-alpha")
    testCompile("org.testfx:testfx-junit:4.0.13-alpha")
    // Only needed for headless testing.
//    testCompile("org.testfx:openjfx-monocle:8u76-b04") // jdk-9+181 for Java 9

    // Spek
    testCompile("org.jetbrains.spek:spek-api:1.1.5")
    testRuntime("org.jetbrains.spek:spek-junit-platform-engine:1.1.5")
}

repositories {
    maven { url = uri("https://dl.bintray.com/jetbrains/spek") }
    mavenCentral()
    mavenLocal()
    jcenter()
}

// Test coverage reporting. Just freestyling into something that seems to work.
tasks {
    // Enable xml for coveralls.
    "jacocoTestReport"(JacocoReport::class) {
        reports {
            html.isEnabled = true
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
