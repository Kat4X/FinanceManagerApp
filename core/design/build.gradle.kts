plugins {
    id("com.team.android.library")
    id("com.team.android.compose")
}

android {
    namespace = "com.team.core.design"
}

dependencies {
    implementation(libs.androidx.core.ktx)
}
