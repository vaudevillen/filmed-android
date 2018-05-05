package me.joshshin.filmed.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.GestureDetector
import android.view.MotionEvent
import me.joshshin.filmed.R

/**
 * Created by Josh Shin on 5/5/18
 */

class FilmedIntroActivity : AppCompatActivity() {
    companion object {
        var hasSeenScreen = false

        fun getIntent(context: Context): Intent {
            return Intent(context, FilmedIntroActivity::class.java)
        }
    }
    val filmedGestureListener = object : GestureDetector.OnGestureListener {
        override fun onShowPress(e: MotionEvent?) { /* no-op*/ }
        override fun onSingleTapUp(e: MotionEvent?) = false
        override fun onDown(e: MotionEvent?) = false
        override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float) = false
        override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
            val intent = MoviesActivity.getIntent(this@FilmedIntroActivity)
            this@FilmedIntroActivity.startActivity(intent)
            return true
        }
        override fun onLongPress(e: MotionEvent?) { /* no-op*/ }

    }

    val gestureDetector by lazy {
        GestureDetector(this@FilmedIntroActivity, filmedGestureListener)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.filmed_intro_screen)

        hasSeenScreen = true
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestureDetector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

    }
}