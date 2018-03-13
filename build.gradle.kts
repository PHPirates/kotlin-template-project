import org.junit.platform.gradle.plugin.JUnitPlatformExtension

group = "deltadak"
version = "0.0"

// JUnit 5
buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.0-M4")
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
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.0.0-M4")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.0.0-M4")
    testRuntime("org.junit.platform:junit-platform-console:1.0.0-M4")

}

repositories {
    jcenter()
}
