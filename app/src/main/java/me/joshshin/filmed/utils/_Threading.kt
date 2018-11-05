package me.joshshin.filmed.utils

import android.os.Handler
import android.os.Looper

/**
 * Created by Josh Shin on 4/28/18
 */

private val mainHandler = Handler(Looper.getMainLooper())

//TODO look for this 'runOnUiThread' in android support lib
internal fun runOnUiThread(fn: () -> Unit) {
    mainHandler.post(fn)
}