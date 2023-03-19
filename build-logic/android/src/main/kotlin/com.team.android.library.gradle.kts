@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    id("com.team.android.base")
}

android {
    lint {
        checkReleaseBuilds = false
    }
}
