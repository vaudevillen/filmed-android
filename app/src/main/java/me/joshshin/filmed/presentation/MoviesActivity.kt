package me.joshshin.filmed.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MotionEvent
import android.view.MotionEvent.*
import android.view.View
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.filmed_intro_screen.*
import kotlinx.android.synthetic.main.movies_activity.*
import kotlinx.android.synthetic.main.movies_recycler.*
import me.joshshin.filmed.adapters.MoviesAdapter
import me.joshshin.filmed.R
import kotlin.math.roundToInt

class MoviesActivity : AppCompatActivity(), View.OnTouchListener {
    var initalX = 0f
    var initialY = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movies_activity)

        intro_screen_container.setOnTouchListener(this)

        movies_recycler.adapter = MoviesAdapter(this)
        movies_recycler.layoutManager = LinearLayoutManager(this)
        movies_recycler.addItemDecoration(
                SpaceItemDecoration(this, this.resources.getDimension(R.dimen.margin_xsmall))
        )
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        return when (event.action) {
            ACTION_DOWN -> {
                initalX = event.x
                initialY = event.y
                true
            }
            ACTION_MOVE -> {
                val xDelta = event.x - initalX
                val yDelta = event.y - initialY
                val transformedParams = v.layoutParams as FrameLayout.LayoutParams
                transformedParams.marginStart += xDelta.roundToInt()
                transformedParams.marginEnd -= xDelta.roundToInt()
                transformedParams.topMargin += yDelta.roundToInt()
                transformedParams.bottomMargin -= yDelta.roundToInt()
                v.layoutParams = transformedParams
                movies_container.invalidate()
                Log.d("@@@", "move move move ${event.rawX}")
                true
            }
            else -> true
        }
    }



}
