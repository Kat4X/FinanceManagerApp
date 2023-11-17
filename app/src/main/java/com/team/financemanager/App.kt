package com.team.financemanager

import android.app.Application
import com.team.core.common.GlobalExceptionHandler
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        loadKoinDI()
        GlobalExceptionHandler.initialize(
            applicationContext = applicationContext,
            activityToBeLaunch = CrashActivity::class.java,
        )

        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun loadKoinDI() {
        startKoin {
            androidLogger(level = Level.ERROR)
            androidContext(this@App)
            modules(appModule)
        }
    }
}
