@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "finwise"
include(":app")
include(":core:data")
include(":core:testing")
include(":core:model")
include(":core:ui")
include(":feature:calculators")
include(":feature:home")
include(":feature:financialposition")
include(":feature:auth")
include(":feature:newsfeed")
