# strela: Functional companion library for Kotlin (Multiplatform)

![Java CI](https://github.com/ltennstedt/strela/workflows/Java%20CI/badge.svg)
[![License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)

strela is an attempt to write a Kotlin Multiplatform lbrary. Please be aware that Kotlin's multiplatform support is 
experimental. Therefor backwards compatability cannot be guaranteed neither on a source, bytecode nor binary level.

strela is a functional companion library inspired by [Scala](https://www.scala-lang.org/) and 
[Arrow](https://arrow-kt.io/) with the exception that strela provides only the data types for exhaustive 
[pattern matching](https://en.wikipedia.org/wiki/Pattern_matching) with the 
[when expression](https://kotlinlang.org/docs/reference/control-flow.html#when-expression).

## Data Types
* Try (Success and Failure)
* Either (Left and Right)
* Option (Some and None)
* Ior (Left, Right and Both)
* Store (Action)
* Triple

## Target backends
* JVM
* JS
* Linux 64 bit

I am generally open to supporting other backends. Since I have neither a Windows nor a Mac installation and no 
experience in developing mobile apps, I am dependent on your help. There is no point in supporting platforms on which 
I can neither test nor debug.

strela is open source and free software and is licensed under the permissive Apache License.

The following experimental features are used:
* [Kotlin Multiplatform](https://kotlinlang.org/docs/reference/multiplatform.html)
* [Kotlin Experimental API Markers](https://kotlinlang.org/docs/reference/experimental.html#experimental-api-markers)
* [Gradle Metadata](https://docs.gradle.org/current/userguide/publishing_gradle_module_metadata.html)

## Implementation details
* Kotlin 1.3
* Sealed classes
* Data classes
* Parameter validation and fast failing
* Factory functions

## Goals
* Complete KDoc
* Clean code

But keep in mind that perfection is not reachable, impressions are very subjective and definitions can vary! ;-)

## Links
* [Kdoc](https://ltennstedt.github.io/strela/dokka/strela/index.html)
* [Gradle Site](https://ltennstedt.github.io/strela/docs/site/index.html)
* [Build Dashboard](https://ltennstedt.github.io/strela/reports/buildDashboard/index.html)

## Developing
The code formatting follows the ktlint code style.

## What about...?
* Coverage? - It does not work yet.
* detekt? - It does not work yet.
* Sonar? - It does not work yet.

## Notes
* Please consider using free software
* Please consider using open standards
* Please consider reporting bugs
* Please consider writing code, patches or documentation for free software projects
* Please consider joining communities via forums, mailing lists or irc
* Please consider donating to free software projects

## Thanks to
* [Oracle](https://www.oracle.com/) for [OpenJDK](https://openjdk.java.net/)
* [JetBrains](https://www.jetbrains.com/) for [Kotlin](https://kotlinlang.org/), 
[IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/)
and [Dokka](https://github.com/Kotlin/dokka/)
* [Pinterest](https://about.pinterest.com/) for [ktlint](https://ktlint.github.io/)
* GitHub for [GitHub](https://github.com/)
* the JUnit team for [JUnit](https://junit.org/)
* Gradle for [Gradle](https://gradle.org/)
* Jonathan Leitschuh for [ktlint-gradle](https://github.com/JLLeitschuh/ktlint-gradle)
* Linus Torvalds for [Git](https://git-scm.com/)
* the developers of [EditorConfig](https://editorconfig.org/)
* the [Apache Software Foundation](http://apache.org/) for the 
[Apache License](http://apache.org/licenses/LICENSE-2.0)
* Stack Exchange for [Stack Overflow](https://stackoverflow.com/)
* Shields.io for [Shields.io](https://shields.io/)
* [Programming Methods Laboratory of École polytechnique fédérale de Lausanne](www.epfl.ch) for 
[Scala](https://www.scala-lang.org/)
* [47 Degrees](https://www.47deg.com/) for [Arrow](https://arrow-kt.io/)
