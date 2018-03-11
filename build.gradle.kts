group = "deltadak"
version = "0.0"

plugins {
    application
    kotlin("jvm") version "1.2.30"
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
}

repositories {
    jcenter()
}
