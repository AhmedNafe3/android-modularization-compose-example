plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.jiftun.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Dependencies.core)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.androidMaterial)
    retrofit()
    hilt()


    implementation(project(mapOf("path" to ":model:apiresponse")))
    implementation(project(mapOf("path" to ":model:entity")))
    implementation(project(mapOf("path" to ":core:di")))
    implementation(project(mapOf("path" to ":core:domain")))
    testImplementation(TestImplementation.junit)
}
kapt {
    correctErrorTypes = true
}