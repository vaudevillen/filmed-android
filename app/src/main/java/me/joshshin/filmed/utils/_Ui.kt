package me.joshshin.filmed.utils

import android.content.Context
import android.util.DisplayMetrics

/**
 * Created by Josh Shin on 4/28/18
 */

internal fun convertDpToPixel(dpValue: Float, context: Context): Float {
    val resources = context.getResources()
    val metrics = resources.getDisplayMetrics()
    return dpValue * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}