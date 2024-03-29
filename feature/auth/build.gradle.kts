plugins {
    id("com.team.android.library")
    id("com.team.android.compose")
}

android {
    namespace = "com.team.feature.auth"
}

dependencies {

    implementation(projects.core.design)

    val koinPlatform = platform(libs.koin.bom)
    implementation(koinPlatform)
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.core.coroutines)
    implementation(libs.koin.compose)

    implementation(libs.androidx.compose.lifecycle)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.com.timber)
}
