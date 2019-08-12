. | .
 --- | ---
Travis | [![Build Status](https://travis-ci.org/PHPirates/kotlin-template-project.svg?branch=master)](https://travis-ci.org/PHPirates/kotlin-template-project)
Coveralls | [![Coverage Status](https://coveralls.io/repos/github/PHPirates/kotlin-template-project/badge.svg?branch=master)](https://coveralls.io/github/PHPirates/kotlin-template-project?branch=master)
Codecov | [![codecov](https://codecov.io/gh/PHPirates/kotlin-template-project/branch/master/graph/badge.svg)](https://codecov.io/gh/PHPirates/kotlin-template-project)

# Template project which contains minimal examples of using Gradle

> Note that both a Gradle (build.gradle) and a Gradle Kotlin DSL (build.gradle.kts) build file are present.

This project aims to provide an example of the use of the Gradle Kotlin DSL with some testing frameworks and libraries, since the official documentation is at the moment of writing very minimal.
There are both a Groovy Gradle ([`build.gradle`](build.gradle.inactive)) and a Kotlin Script Gradle ([`build.gradle.kts`](build.gradle.kts)) build file present which do roughly the same, which may make translation a bit easier.
For other translation examples, see [below](#translations).

This is the Kotlin equivalent of this (older) [java template project](https://github.com/PHPirates/java-template-project).

It makes use of
* Kotlin
* Kotlin Script Gradle or Gradle Kotlin DSL 
* A normal, Groovy Gradle build file is also present
* JaCoCo for generating test reports
* Codecov.io which takes the JaCoCo report and shows some statistics

There are tests using
* kotlintest (will be run by Gradle since kotlintest 3)
* JUnit 5
* TestFX (for using JavaFX elements)
* Spek 2

Note you have to install JavaFX properly, making sure you install one for the Java version you are using (e.g. on Arch Linux, install `jre8-openjdk jdk8-openjdk java8-openjfx`).

## How to add Gradle to your existing project

Decide whether you want to use Groovy Gradle (older and widely used) or the Gradle Kotlin DSL (newer but no documentation and nobody uses it, yet).

* Copy the `build.gradle.kts` and `settings.gradle.kts` (Gradle Kotlin DSL, as you can see from the `.kts` extension) or the `build.gradle` (Groovy Gradle, it this repo it may be named `build.gradle.inactive` but just rename it to `build.gradle`)
* Read through the file you just copied and change the relevant names, remove things of which you are sure you don't need them
* Copy the `gradlew`, `gradlew.bat` and `gradle/` files and folder.
* Go to File | New | Module from Existing Sources and select your `build.gradle` file. Make sure 'Use gradle wrapper' is selected. Select a different Gradle JVM if prompted.
* You should commit all the files you added, but not the generated files in `.gradle/`.
* You can run Gradle tasks from the Gradle window on the right, for example `build` to build your project, `run` to run the main class if you have one or `check` to run tests.
* It is recommended that you use a continuous integration service like Travis, which will build and run tests on their server when you push a commit. Install the Travis GitHub App by going to the GitHub marketplace, and after that copy the `.travis.yml`, possibly remove parts you don't need.

## Tips
This was only tested with IntelliJ.

* You can quickly import the project into IntelliJ by importing the `build.gradle.kts` file. Select the Gradle wrapper if needed.

* To run Gradle tasks, e.g. to run all tests (the verification/check task) or to start the main class (application/run) open the Gradle toolbar on the right and double-click (or right-click and debug) the task.

* Alternatively, without IntelliJ, you can run `gradlew test` on the terminal to run the tests via gradle with the gradle wrapper (so you don't have to first install gradle locally by hand).

* If you see all gradle keywords greyed out you may want to link the Gradle project in IntelliJ, if you do not see a popup asking you to do so then go to modules - import module and select your `build.gradle.kts`.

Feel free to use GitHub emojis as for example by [François Parmentier](https://gist.github.com/parmentf/035de27d6ed1dce0b36a).

## <a name="translations">Some example translations from Groovy Gradle to Kotlin Script Gradle</a>

### Task configuration

Groovy Gradle:
```
// This is a configuration for the shadowJar task.
shadowJar{
  classifier = 'deploy'
}
```

Kotlin Script Gradle:
```
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

tasks {
    // This is a configuration for the shadowJar task.
    "shadowJar"(ShadowJar::class) {
        classifier = "deploy"
    }
}
```

## Corresponding SO questions
[Run JUnit 5 with Gradle](https://stackoverflow.com/questions/44429751/how-to-use-junit-5-with-gradle)

[Run kotlintest and JUnit 5 tests with Gradle](https://stackoverflow.com/questions/49638462/how-to-run-kotlintest-tests-using-the-gradle-kotlin-dsl)

[Upload test reports of Kotlin sources to Coveralls](https://stackoverflow.com/questions/50903389/how-to-upload-test-reports-of-kotlin-sources-to-coveralls)

[The DefaultSourceDirectorySet constructor has been deprecated. How to use the ObjectFactory service?](https://stackoverflow.com/questions/53461821/the-defaultsourcedirectoryset-constructor-has-been-deprecated-how-to-use-the-ob)
