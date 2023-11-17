plugins {
    `kotlin-dsl`
}

group = "com.team.buildlogic"

repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.ksp.gradlePlugin)

    // Workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins.register("com.team.android.app.signing") {
        id = "com.team.android.app.signing"
        implementationClass = "AppSigningPlugin"
    }
}
