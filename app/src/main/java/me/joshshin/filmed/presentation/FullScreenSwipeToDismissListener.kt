package me.joshshin.filmed.presentation

import android.graphics.Rect
import androidx.transition.Explode
import androidx.transition.Transition
import androidx.transition.TransitionManager
import android.view.MotionEvent
import android.view.MotionEvent.*
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

/**
 * Created by Josh Shin on 5/6/18
 */

class FullScreenSwipeToDismissListener : View.OnTouchListener {
    companion object {
        private const val MINIMUM_SWIPE_DISTANCE = 60f
        private const val ANIMATION_DURATION = 300L
    }

    private var initialX = 0f
    private var initialY = 0f
    private var onDownTouchedTime: Long = 0

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        return when (event.action) {
            ACTION_DOWN -> {
                initialX = event.x
                initialY = event.y
                onDownTouchedTime = event.eventTime
                true
            }
            ACTION_MOVE -> {
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
            ACTION_UP -> {
                val xDelta = event.x - initialX
                val yDelta = event.y - initialY

                val downToUpTime = onDownTouchedTime - event.eventTime
                if (didExceedMinSwipeDistance(xDelta, yDelta) && downToUpTime < 200) {
                    val rect = Rect()
                    v.getGlobalVisibleRect(rect)
                    val explosion = Explode().apply {
                        duration = ANIMATION_DURATION
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

    private fun didExceedMinSwipeDistance(xDelta: Float, yDelta: Float): Boolean {
        return xDelta.absoluteValue > MINIMUM_SWIPE_DISTANCE || yDelta.absoluteValue > MINIMUM_SWIPE_DISTANCE
    }
}