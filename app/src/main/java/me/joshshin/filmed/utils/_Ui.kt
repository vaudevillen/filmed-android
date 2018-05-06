package me.joshshin.filmed.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.View

/**
 * Created by Josh Shin on 4/28/18
 */

internal fun convertDpToPixel(dpValue: Float, context: Context): Float {
    val resources = context.getResources()
    val metrics = resources.getDisplayMetrics()
    return dpValue * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}

internal fun View.setGone() {
    this.visibility = View.GONE
}

internal fun View.setVisible() {
    this.visibility = View.VISIBLE
}

internal fun View.toggleVisibility() {
    if (this.visibility == View.VISIBLE) {
        this.setGone()
    } else {
        this.setVisible()
    }
}