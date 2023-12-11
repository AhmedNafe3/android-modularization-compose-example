pluginManagement {
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

rootProject.name = "android-modularization-compose-example"
include(":app")
include(":core:data")
include(":core:di")
include(":core:domain")
include(":core:ui")
include(":model:entity")
include(":model:apiresponse")
