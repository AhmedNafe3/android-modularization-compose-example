import org.gradle.api.artifacts.dsl.Dependencies
import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterial}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    // testing
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
}

object TestImplementation {
    const val junit = "junit:junit:${Versions.testImplJunit}"
    const val kotlinxCoroutine =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinxCoroutine}"
    const val turbine = "app.cash.turbine:turbine:${Versions.turbine}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInline}"
}

object AndroidTestImplementation {
    const val junit = "androidx.test.ext:junit:${Versions.androidTestImplJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.androidTestEspresso}"
}

object Firebase {
    const val bom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val analytics = "com.google.firebase:firebase-analytics-ktx"
    const val database = "com.google.firebase:firebase-database-ktx:${Versions.firebaseDatabase}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConvertor = "com.squareup.retrofit2:converter-gson:${Versions.gsonConvertor}"
    const val googleGson = "com.google.code.gson:gson:${Versions.googleGson}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val scalersConvertors =
        "com.squareup.retrofit2:converter-scalars:${Versions.scalerConvertor}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
    const val rxJavaRetrofit =
        "com.github.akarnokd:rxjava3-retrofit-adapter:${Versions.rxJavaRetrofit}"
    const val okHttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
}

object Coroutines {
    const val coroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
}

object CoroutinesLifecycleScope {
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.coroutineLifecycleScope}"
    const val lifeCycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.coroutineLifecycleScope}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val annotationProcessor = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object CoilImageLoadingLib {
    const val coil = "io.coil-kt:coil-compose:${Versions.coilImageLoading}"
}

object ViewModelDelegate {
    const val viewModelDeligate = "androidx.activity:activity-ktx:${Versions.viewModelDeligate}"
}

object DaggerHilt {
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
}

object DaggerHiltTestingTestImpl {
    // For Robolectric tests.
    const val daggerHiltTestImplRobolectric =
        "com.google.dagger:hilt-android-testing:${Versions.daggerHiltTestImpl}"
    const val daggerHiltKaptTestRobolectric =
        "com.google.dagger:hilt-android-compiler:${Versions.daggerHiltTestImpl}"

    // For instrumented tests.
    const val daggerHiltAndroidTestImpl =
        "com.google.dagger:hilt-android-testing:${Versions.daggerHiltAndroidTestImpl}"
    const val daggerHiltAndroidTestKapt =
        "com.google.dagger:hilt-android-compiler:${Versions.daggerHiltAndroidTestImpl}"
}

object Room {
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
}

object CircularProgressBar {
    const val swipeRefresh =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefresh}"
}

object LottieAnimations {
    const val lottieAnimations = "com.airbnb.android:lottie:${Versions.lottieAnimations}"
}

object Compose {
    const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val composeViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModel}"
    const val composeBom = "androidx.compose:compose-bom:${Versions.composePom}"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeGraphics = "androidx.compose.ui:ui-graphics"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4"
    const val manifestTest = "androidx.compose.ui:ui-test-manifest"
    const val composeRuntime = "androidx.compose.runtime:runtime"
    const val composeLifecycle = "androidx.lifecycle:lifecycle-runtime-compose"
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
}

object Plugins {
    const val ANDROID_LIBRARY = "com.android.library"
    const val KOTLIN_ANDROID = "org.jetbrains.kotlin.android"
    const val DAGGER_HILT = "com.google.dagger.hilt.android"
    const val KOTLIN_KAPT = "kapt"
}

object Navigation {
    // Java language implementation
    const val navigationJavaFragment =
        "androidx.navigation:navigation-fragment:${Versions.navVersion}"
    const val navigationUiJavaFragment = "androidx.navigation:navigation-ui:${Versions.navVersion}"

    // Kotlin
    const val navigationKotlinFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    const val navigationUiKotlinFragment =
        "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"

    // Jetpack Compose Integration
    const val navigationUiKotlinCompose =
        "androidx.navigation:navigation-compose:${Versions.navVersion}"    // Jetpack Compose Integration
    const val navigationHiltCompose =
        "androidx.hilt:hilt-navigation-compose:${Versions.navHiltVersion}"
}


fun DependencyHandler.room() {
    implementation(Room.roomRuntime)
    implementation(Room.roomKtx)
    kapt(Room.roomCompiler)
}

fun DependencyHandler.retrofit() {
    implementation(Retrofit.retrofit)
    implementation(Retrofit.moshiConverter)
    implementation(Retrofit.okHttp)
    implementation(Retrofit.okHttpLoggingInterceptor)
    implementation(Retrofit.gsonConvertor)
    implementation(Retrofit.googleGson)
}

fun DependencyHandler.compose() {
    implementation(platform(Compose.composeBom))
    implementation(Compose.composeUi)
    implementation(Compose.composeRuntime)
    implementation(Compose.composeGraphics)
    implementation(Compose.composeUiTooling)
    implementation(Compose.composeMaterial3)
    implementation(Compose.composeLifecycle)
    debugImplementation(Compose.composeUiToolingPreview)
}
fun DependencyHandler.coil(){
    implementation(Compose.coil)

}

fun DependencyHandler.hilt() {
    implementation(DaggerHilt.hilt)
    kapt(DaggerHilt.hiltCompiler)
}

fun DependencyHandler.coroutines() {
    implementation(Coroutines.coroutineAndroid)
    implementation(Coroutines.coroutineCore)
    implementation(CoroutinesLifecycleScope.lifecycleViewModel)
    implementation(CoroutinesLifecycleScope.lifeCycleRuntime)
}

fun DependencyHandler.firebase() {
    implementation(platform(Firebase.bom))
    implementation(Firebase.analytics)
    implementation(Firebase.database)
}

fun DependencyHandler.test() {
    testImplementation(TestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.espresso)
}

fun DependencyHandler.navigation() {
    implementation(Navigation.navigationUiKotlinCompose)
    implementation(Navigation.navigationHiltCompose)
}


fun DependencyHandler.booksDataSource() {
    // implementation(project(":books-datasource"))
}
