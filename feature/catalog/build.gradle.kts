plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.jiftun.catalog"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
    }
}

dependencies {
    implementation(Dependencies.core)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.androidMaterial)
    implementation(project(mapOf("path" to ":core:domain")))
    implementation(project(mapOf("path" to ":model:entity")))
    implementation(project(mapOf("path" to ":core:ui")))
    hilt()
    compose()
    navigation()
    coil()
    testImplementation(TestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.espresso)

    coroutines()
}
kapt {
    correctErrorTypes = true
}