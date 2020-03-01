/*
 * Copyright 2020 Lars Tennstedt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    kotlin("multiplatform") version "1.3.61"
    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
    id("org.jetbrains.dokka") version "0.10.1"
    `maven-publish`
    `project-report`
    `build-dashboard`
    id("gradle.site") version "0.6"
    idea
}

group = "com.github.ltennstedt"
version = "0.0.1-SNAPSHOT"
description = "Functional companion for Kotlin Multiplatform"

kotlin {
    jvm {
        @Suppress("UNUSED_VARIABLE")
        val main by compilations.getting {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    js {
        @Suppress("UNUSED_VARIABLE")
        val main by compilations.getting {
            kotlinOptions {
                sourceMap = true
            }
        }
        targets {
            browser {
                testTask {
                    useMocha()
                }
            }
        }
    }
    linuxX64 {
        binaries {
            sharedLib()
        }
    }
    sourceSets.all {
        languageSettings.apply {
            val kotlinVersion = "1.3"
            languageVersion = kotlinVersion
            apiVersion = kotlinVersion
            useExperimentalAnnotation("kotlin.Experimental")
        }
    }
    sourceSets {
        @Suppress("UNUSED_VARIABLE")
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        @Suppress("UNUSED_VARIABLE")
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        @Suppress("UNUSED_VARIABLE")
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }
        @Suppress("UNUSED_VARIABLE")
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
        @Suppress("UNUSED_VARIABLE")
        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
        @Suppress("UNUSED_VARIABLE")
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}

tasks {
    dokka {
        configuration {
            jdkVersion = 8
            noJdkLink = true
            noStdlibLink = true
        }
    }
    wrapper {
        gradleVersion = "6.1.1"
    }
    register("default") {
        val jvmMainClasses by getting
        val jsMainClasses by getting
        val jvmTestClasses by getting
        val jsTestClasses by getting
        val linuxX64MainKlibrary by getting
        val linuxX64TestKlibrary by getting
        val jvmTest by getting
        val jsBrowserTest by getting
        val linuxX64Test by getting
        val ktlintCheck by getting
        val jvmJar by getting
        val jvmSourcesJar by getting
        val jsJar by getting
        val jsSourcesJar by getting
        val linuxX64Binaries by getting
        val publishJvmPublicationToMavenLocal by getting
        val publishJsPublicationToMavenLocal by getting
        val publishLinuxX64PublicationToMavenLocal by getting
        dependsOn(
            jvmMainClasses,
            jsMainClasses,
            linuxX64MainKlibrary,
            jvmTestClasses,
            jsTestClasses,
            linuxX64TestKlibrary,
            jvmTest,
            jsBrowserTest,
            linuxX64Test,
            ktlintCheck,
            dokka,
            jvmJar,
            jvmSourcesJar,
            jsJar,
            jsSourcesJar,
            linuxX64Binaries,
            projectReport,
            buildDashboard,
            generateSiteHtml,
            publishJvmPublicationToMavenLocal,
            publishJsPublicationToMavenLocal,
            publishLinuxX64PublicationToMavenLocal
        )
    }
}

site {
    websiteUrl.set("https://github.com/ltennstedt/strela")
    vcsUrl.set("https://github.com/ltennstedt/strela.git")
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

repositories {
    jcenter()
}
