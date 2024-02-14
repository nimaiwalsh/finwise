plugins {
    id("ittybittyapps.android.library")
    id("ittybittyapps.android.library.compose")
    kotlin("kapt")
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    api(libs.junit4)
    api(libs.androidx.test.core)
    api(libs.kotlinx.coroutines.test)
    api(libs.turbine)

    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.runner)
    api(libs.androidx.test.rules)
    api(libs.androidx.compose.ui.test)
    api(libs.hilt.android.testing)

    debugApi(libs.androidx.compose.ui.testManifest)
}
android {
    namespace = "com.ittybittyapps.apptemplate.core.testing"
}
