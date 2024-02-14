plugins {
    id("ittybittyapps.android.library")
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.androidx.dataStore.core)
    implementation(libs.androidx.dataStore.preferences)

    testImplementation(project(":core:testing"))
}
android {
    namespace = "com.ittybittyapps.apptemplate.core.datastore"
}
