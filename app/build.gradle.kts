@file:Suppress("UnstableApiUsage")

plugins {
    id("ittybittyapps.android.application")
    id("ittybittyapps.android.application.compose")
    id("ittybittyapps.android.hilt")
}

android {
    namespace = "com.ittybittyapps.apptemplate.android"

    defaultConfig {
        applicationId = "com.ittybittyapps.apptemplate"
        versionCode = findProperty("versionCode")?.toString()?.toIntOrNull() ?: 1
        versionName = findProperty("versionName")?.toString() ?: "1"

        testInstrumentationRunner = "com.ittybittyapps.apptemplate.core.testing.CustomTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    signingConfigs {
        create("release") {
            storeFile = file("../keystore.jks")
            storePassword = System.getenv("KEYSTORE_PASSWORD")
            keyAlias = System.getenv("KEY_ALIAS")
            keyPassword = System.getenv("KEY_PASSWORD")
        }
    }
    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":core:data"))
    implementation(project(":core:model"))

    implementation(project(":feature:home"))

    androidTestImplementation(project(":core:testing"))
    androidTestImplementation(kotlin("test"))
    debugImplementation(libs.androidx.compose.ui.testManifest)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.lifecycle.runtimeCompose)
}
