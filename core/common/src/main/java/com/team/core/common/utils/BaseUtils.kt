package com.team.core.common.utils

import android.content.Context
import android.widget.Toast
import com.team.core.common.BuildConfig

fun Context.debuggingToast(value: String) {
    if (BuildConfig.DEBUG)
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
}