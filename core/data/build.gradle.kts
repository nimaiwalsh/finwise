plugins {
    id("ittybittyapps.android.library")
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:datastore"))

    implementation(libs.kotlinx.coroutines.android)

    testImplementation(project(":core:testing"))
}
android {
    namespace = "com.ittybittyapps.apptemplate.core.data"
}
