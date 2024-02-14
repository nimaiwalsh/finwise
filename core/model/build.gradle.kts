plugins {
    id("finwise.library")
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}
android {
    namespace = "com.finwise.core.model"
}
