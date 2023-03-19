@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("com.team.android.base")
}

val lintConfiguration = file("$rootProject/.config/lint/config.xml")

android {
    lint {
        checkReleaseBuilds = false
        checkDependencies = true

        lintConfig = lintConfiguration
    }
}
