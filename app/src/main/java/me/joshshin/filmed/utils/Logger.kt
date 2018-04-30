package me.joshshin.filmed.utils

import android.util.Log
import me.joshshin.filmed.BuildConfig

/**
 * Created by Josh Shin on 4/28/18
 *
 * Version of Log that only runs in Debug builds
 * @see [android.util.Log]
 */
object Logger {
    private fun returnIfDebug() {
        if (BuildConfig.DEBUG) return
    }

    private fun getTag(clazz: Any): String {
        return clazz::class.java.simpleName
    }

    fun v(clazz: Any, msg: String) {
        returnIfDebug()
        Log.v(getTag(clazz), msg)
    }

    fun v(clazz: Any, msg: String, tr: Throwable) {
        returnIfDebug()
        Log.v(getTag(clazz), msg, tr)
    }


    fun d(clazz: Any, msg: String) {
        returnIfDebug()
        Log.d(getTag(clazz), msg)
    }


    fun d(clazz: Any, msg: String, tr: Throwable) {
        returnIfDebug()
        Log.d(getTag(clazz), msg, tr)
    }

    fun i(clazz: Any, msg: String) {
        returnIfDebug()
        Log.i(getTag(clazz), msg)
    }

    fun i(clazz: Any, msg: String, tr: Throwable) {
        returnIfDebug()
        Log.i(getTag(clazz), msg, tr)
    }

    fun w(clazz: Any, msg: String) {
        returnIfDebug()
        Log.w(getTag(clazz), msg)
    }

    fun w(clazz: Any, msg: String, tr: Throwable) {
        returnIfDebug()
        Log.w(getTag(clazz), msg, tr)
    }

    fun w(clazz: Class<*>, tr: Throwable) {
        returnIfDebug()
        Log.w(getTag(clazz), tr)
    }

    fun e(clazz: Any, msg: String) {
        returnIfDebug()
        Log.e(getTag(clazz), msg)
    }

    fun e(clazz: Any, msg: String, tr: Throwable) {
        returnIfDebug()
        Log.e(getTag(clazz), msg, tr)
    }

}