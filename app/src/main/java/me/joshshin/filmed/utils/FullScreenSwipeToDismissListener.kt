package me.joshshin.filmed.utils

import android.graphics.Rect
import android.support.transition.Explode
import android.support.transition.Transition
import android.support.transition.TransitionManager
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

/**
 * Created by Josh Shin on 5/6/18
 */

class FullScreenSwipeToDismissListener : View.OnTouchListener {
    var initialX = 0f
    var initialY = 0f
    val swipeThreshold = 1f

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        return when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                initialX = event.x
                initialY = event.y
                true
            }
            MotionEvent.ACTION_MOVE -> {
                val xDelta = event.x - initialX
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
                val xDelta = event.x - initialX
                val yDelta = event.y - initialY
                if (xDelta.absoluteValue > swipeThreshold || yDelta.absoluteValue > swipeThreshold) {
                    val rect = Rect()
                    v.getGlobalVisibleRect(rect)
                    val explosion = Explode().apply {
                        duration = 400
                        epicenterCallback = object : Transition.EpicenterCallback() {
                            override fun onGetEpicenter(transition: Transition) = rect
                        }
                    }
                    TransitionManager.beginDelayedTransition((v.parent as ViewGroup), explosion)
                    (v.parent as ViewGroup).removeView(v)
                } else {
                    val transformedParams = v.layoutParams as FrameLayout.LayoutParams
                    transformedParams.marginStart = 0
                    transformedParams.marginEnd = 0
                    transformedParams.topMargin = 0
                    transformedParams.bottomMargin = 0
                    v.layoutParams = transformedParams
                    TransitionManager.beginDelayedTransition(v.parent as ViewGroup)
                }
                true
            }
            else -> true
        }
    }
}