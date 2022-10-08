package com.team.core.common.utils

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.google.gson.Gson
import com.team.core.common.BuildConfig

const val INTENT_DATA_NAME = "INTENT_DATA_NAME"

fun Context.debuggingToast(value: String) {
    if (BuildConfig.DEBUG)
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
}

fun launchActivity(
    applicationContext: Context,
    activity: Class<*>,
    exception: Throwable
) {
    val crashedIntent = Intent(applicationContext, activity).also {
        it.putExtra(INTENT_DATA_NAME, Gson().toJson(exception))
    }
    crashedIntent.addFlags( // Clears all previous activities. So backstack will be gone.
        Intent.FLAG_ACTIVITY_CLEAR_TOP or
                Intent.FLAG_ACTIVITY_NEW_TASK
    )
    crashedIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
    applicationContext.startActivity(crashedIntent)
}