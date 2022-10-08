package com.team.financemanager

import android.app.Application
import com.team.core.common.GlobalExceptionHandler
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class FMApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        GlobalExceptionHandler.initialize(
            applicationContext = applicationContext,
            activityToBeLaunch = CrashActivity::class.java
        )

        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}