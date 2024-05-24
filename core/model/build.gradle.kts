plugins {
    id("finwise.library")
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
}
android {
    namespace = "com.finwise.core.model"
}
