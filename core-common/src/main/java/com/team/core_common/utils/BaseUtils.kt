package com.team.core_common.utils

import android.content.Context
import android.widget.Toast
import com.team.core_common.BuildConfig

fun Context.debuggingToast(value: String) {
    if (BuildConfig.DEBUG)
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
}