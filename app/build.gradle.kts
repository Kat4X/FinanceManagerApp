@file:Suppress("UnstableApiUsage")

plugins {
    id("com.team.android.app")
    id("com.team.android.compose")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.team.financemanager"

    defaultConfig {
        applicationId = "com.team.financemanager"
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
        resourceConfigurations.addAll(listOf("en", "ru", "kk"))
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
    }
    bundle {
        language { enableSplit = true }
        density { enableSplit = true }
        abi { enableSplit = true }
    }

    buildTypes {
        getByName("debug") {
            manifestPlaceholders["isCrashlyticsEnabled"] = "false"

            isMinifyEnabled = false
            isShrinkResources = false
        }
        getByName("release") {
            manifestPlaceholders["isCrashlyticsEnabled"] = "true"

            isMinifyEnabled = true
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules/proguard-rules.pro",
            )
        }
        /*benchmark {
            signingConfig signingConfigs.debug
            matchingFallbacks = ['release']
            debuggable false
        }*/
    }

    buildFeatures {
        buildConfig = true
    }

    /*kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-opt-in=kotlinx.coroutines.FlowPreview"
        )
    }*/

    packaging {
        resources.excludes.addAll(
            listOf(
                "/META-INF/{AL2.0,LGPL2.1}",
                "META-INF/*.kotlin_module",
                "META-INF/notice.txt",
            )
        )
    }
}

dependencies {

    implementation(projects.core.common)
    implementation(projects.core.design)
    implementation(projects.core.navigation)
    implementation(projects.feature.auth)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.com.timber)
    implementation(libs.androidx.activity.compose)

    implementation(libs.accompanist.systemuicontroller)
}
