package com.team.core.common

import android.content.Context
import android.content.Intent
import com.google.gson.Gson
import com.team.core.common.utils.launchActivity
import timber.log.Timber
import kotlin.system.exitProcess

class GlobalExceptionHandler private constructor(
    private val applicationContext: Context,
    private val defaultHandler: Thread.UncaughtExceptionHandler,
    private val activityToBeLaunch: Class<*>
): Thread.UncaughtExceptionHandler {

    override fun uncaughtException(t: Thread, e: Throwable) {
        try {
            launchActivity(applicationContext, activityToBeLaunch, e)
            exitProcess(0)
        } catch (e: Exception) {
            defaultHandler.uncaughtException(t, e)
        }
    }

    companion object {
        private const val INTENT_DATA_NAME = "CrashData"
        private const val TAG = "CustomExceptionHandler"

        fun initialize(
            applicationContext: Context,
            activityToBeLaunch: Class<*>
        ) {
            val handler = GlobalExceptionHandler(
                applicationContext = applicationContext,
                defaultHandler = Thread.getDefaultUncaughtExceptionHandler() as Thread.UncaughtExceptionHandler,
                activityToBeLaunch = activityToBeLaunch
            )
            Thread.setDefaultUncaughtExceptionHandler(handler)
        }

        fun getThrowableFromIntent(intent: Intent): Throwable? {
            return try {
                Gson().fromJson(intent.getStringExtra(INTENT_DATA_NAME), Throwable::class.java)
            } catch (e: Exception) {
                Timber.e("GlobalExceptionHandler: getThrowableFromIntentLog=$e")
                return null
            }
        }
    }
}