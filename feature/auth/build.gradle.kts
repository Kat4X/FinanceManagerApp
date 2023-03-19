plugins {
    id("com.team.android.library")
    id("com.team.android.compose")
    id("com.team.android.koin")
}

android {
    namespace = "com.team.feature.auth"
}

dependencies {

    implementation(projects.core.design)
    implementation(libs.androidx.compose.lifecycle)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.com.timber)
}