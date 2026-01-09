import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    kotlin {
        sourceSets {
            val commonMain by getting {
                dependencies {
                    implementation(compose.runtime)
                    implementation(compose.foundation)
                    implementation(compose.material3)
                    implementation(compose.material)
                    implementation(compose.ui)
                    implementation(compose.components.resources)
                    implementation(compose.components.uiToolingPreview)
                    implementation(compose.materialIconsExtended)

                    // Библиотека Cupertino
                    implementation("io.github.schott12521:cupertino:2.0.8")
                    implementation("io.github.schott12521:cupertino-icons-extended:2.0.8")


                    // Lifecycle
                    implementation(libs.androidx.lifecycle.viewmodelCompose)
                    implementation(libs.androidx.lifecycle.runtimeCompose)

                    // Ktor Core
                    implementation("io.ktor:ktor-client-core:2.3.12")
                    implementation("io.ktor:ktor-client-content-negotiation:2.3.12")
                    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.12")

                    // Navigation (KMP версия)
                    implementation("org.jetbrains.androidx.navigation:navigation-compose:2.7.0-alpha07")
                }
            }

            val androidMain by getting {
                dependencies {
                    implementation(compose.preview)
                    implementation(libs.androidx.activity.compose)
                    implementation("io.ktor:ktor-client-okhttp:2.3.12") // Движок только тут
                }
            }

            val iosMain by creating {
                dependsOn(commonMain)
                dependencies {
                    implementation("io.ktor:ktor-client-darwin:2.3.12") // Движок для iOS
                }
            }
        }
    }
}

android {
    namespace = "com.example.psihosamatickmobile"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.example.psihosamatickmobile"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

