plugins {
    id("ittybittyapps.android.library")
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}
android {
    namespace = "com.ittybittyapps.apptemplate.core.model"
}
