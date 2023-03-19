plugins {
    id("com.team.android.library")
}

android {
    namespace = "com.team.core.common"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation("com.google.code.gson:gson:2.10.1")
    implementation(libs.com.timber)
}