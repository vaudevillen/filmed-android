package me.joshshin.filmed

import android.support.transition.TransitionManager
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import me.joshshin.filmed.utils.runOnUiThreadDelayed
import me.joshshin.filmed.utils.setGone
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

/**
 * Created by Josh Shin on 5/6/18
 */

class FullScreenSwipeToDismissListener : View.OnTouchListener {
    var initalX = 0f
    var initialY = 0f
    val swipeThreshold = 0.2f

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        return when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                initalX = event.x
                initialY = event.y
                true
            }
            MotionEvent.ACTION_MOVE -> {
                val xDelta = event.x - initalX
                val yDelta = event.y - initialY
                val transformedParams = v.layoutParams as FrameLayout.LayoutParams
                transformedParams.marginStart += xDelta.roundToInt()
                transformedParams.marginEnd -= xDelta.roundToInt()
                transformedParams.topMargin += yDelta.roundToInt()
                transformedParams.bottomMargin -= yDelta.roundToInt()
                v.layoutParams = transformedParams
                (v.parent as View).invalidate()
                true
            }
            MotionEvent.ACTION_UP -> {
                val finalX = event.x
                val finalY = event.y
                val xDelta = finalX - initalX
                val yDelta = finalY - initialY
                val transformedParams = v.layoutParams as FrameLayout.LayoutParams
                if (xDelta.absoluteValue > swipeThreshold ||
                        yDelta.absoluteValue > swipeThreshold) {
                    if (xDelta > 0) {
                        transformedParams.marginStart += v.width
                        transformedParams.marginEnd -= v.width
                    } else {
                        transformedParams.marginStart -= v.width
                        transformedParams.marginEnd += v.height
                    }
                    if (yDelta > 0) {
                        transformedParams.topMargin += v.height
                        transformedParams.bottomMargin -= v.height
                    } else {
                        transformedParams.topMargin -= v.height
                        transformedParams.bottomMargin += v.height
                    }
                    v.layoutParams = transformedParams
                    (v.parent as View).invalidate()
                    TransitionManager.beginDelayedTransition(v.parent as ViewGroup)
                    runOnUiThreadDelayed(700, {
                        v.setGone()
                    })
                } else {
                    transformedParams.marginStart = 0
                    transformedParams.marginEnd = 0
                    transformedParams.topMargin = 0
                    transformedParams.bottomMargin = 0
                    v.layoutParams = transformedParams
                    TransitionManager.beginDelayedTransition(v.parent as ViewGroup)
                    (v.parent as View).invalidate()
                }
                true
            }
            else -> true
        }
    }
}