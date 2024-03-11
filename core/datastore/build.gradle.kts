import java.io.FileInputStream
import java.util.Properties

plugins {
    id("finwise.library")
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.androidx.dataStore.core)
    implementation(libs.androidx.dataStore.preferences)

    testImplementation(project(":core:testing"))
}
android {
    namespace = "com.finwise.core.datastore"
}
