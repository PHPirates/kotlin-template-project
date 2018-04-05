[![Build Status](https://travis-ci.org/PHPirates/kotlin-template-project.svg?branch=master)](https://travis-ci.org/PHPirates/kotlin-template-project)

# Template project for simple use cases of Gradle

This project aims to provide an example of the use of the Gradle Kotlin DSL with some testing frameworks and libraries, since the official documentation is at the moment of writing very minimal.

This is the Kotlin equivalent of this (older) [java template project](https://github.com/PHPirates/java-template-project).

It makes use of
* Kotlin
* Kotlin Script Gradle or Gradle Kotlin DSL

There are tests using
* kotlintest (will be run by Gradle since kotlintest 3)
* JUnit 5
* TestFX (for using JavaFX elements)
* Spek

## Tips
This was only tested with IntelliJ.

* You can quickly import the project into IntelliJ by importing the `build.gradle` file.

* You can run `gradlew test` on the terminal to run the tests via gradle with the gradle wrapper (so you don't have to first install gradle locally by hand).

* If you see all gradle keywords greyed out you may want to link the Gradle project in IntelliJ, if you do not see a popup asking you to then go to modules - import module and select your build.gradle.

## Corresponding SO questions
[Run JUnit 5 with Gradle](https://stackoverflow.com/questions/44429751/how-to-use-junit-5-with-gradle)

[Run kotlintest and JUnit 5 tests with Gradle](https://stackoverflow.com/questions/49638462/how-to-run-kotlintest-tests-using-the-gradle-kotlin-dsl)
