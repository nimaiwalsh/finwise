import java.io.FileInputStream
import java.util.Properties

plugins {
    id("finwise.library")
    alias(libs.plugins.kotlinx.serialization)
}

// Add secret keys
val secretPropertiesFile = rootProject.file("secrets.properties")
val secretProperties = Properties()
secretProperties.load(FileInputStream(secretPropertiesFile))

android {
    namespace = "com.finwise.core.data"

    defaultConfig {
        buildConfigField(
            type = "String",
            name = "MARKETAUX_API_KEY",
            value = secretProperties.getProperty("MARKETAUX_API_KEY"),
        )
    }
}

dependencies {
    implementation(libs.androidx.dataStore.core)
    implementation(libs.androidx.dataStore.preferences)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okHttp3.logging.interceptor)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.kotlinx.serialization)

    implementation(project(":core:model"))
    testImplementation(project(":core:testing"))
}
