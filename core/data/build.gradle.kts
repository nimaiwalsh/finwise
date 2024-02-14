plugins {
    id("finwise.library")
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:datastore"))

    implementation(libs.kotlinx.coroutines.android)

    testImplementation(project(":core:testing"))
}
android {
    namespace = "com.finwise.core.data"
}
