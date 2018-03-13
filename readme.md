# Template project for simple use cases of Gradle

This is the Kotlin equivalent of this [java template project](https://github.com/PHPirates/java-template-project).

It makes use of
* Kotlin
* Kotlin Script Gradle or Gradle Kotlin DSL
There are tests using
* kotlintest (will not be run by Gradle when using JUnit 5 as well)
* JUnit 5

## Tips
This was only tested with IntelliJ.

* You can quickly import the project into IntelliJ by importing the `build.gradle` file.

* You can run `gradlew test` on the terminal to run the tests via gradle with the gradle wrapper (so you don't have to first install gradle locally by hand).

* If you see all gradle keywords greyed out you may want to link the Gradle project in IntelliJ, if you do not see a popup asking you to then go to modules - import module and select your build.gradle.
