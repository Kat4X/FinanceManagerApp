plugins {
    id("com.team.android.library")
    id("com.team.android.compose")
}

android {
    namespace = "com.team.feature.main"
}

dependencies {

    /**
     * Имплементация библиотеки Koin
     * */
    val koinPlatform = platform(libs.koin.bom)
    implementation(koinPlatform)
    implementation(libs.koin.core)
    implementation(libs.koin.ktor)
    implementation(libs.koin.android)
    implementation(libs.koin.core.coroutines)
    implementation(libs.koin.compose)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
