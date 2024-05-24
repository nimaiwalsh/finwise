import java.io.FileInputStream
import java.util.Properties

plugins {
    id("finwise.library")
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
    implementation(project(":core:model"))
    implementation(project(":core:datastore"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(project(":core:testing"))
}
