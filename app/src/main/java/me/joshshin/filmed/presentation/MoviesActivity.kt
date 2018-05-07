package me.joshshin.filmed.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.ViewGroup
import kotlinx.android.synthetic.main.filmed_intro_screen.*
import kotlinx.android.synthetic.main.movies_recycler.*
import me.joshshin.filmed.R
import me.joshshin.filmed.presentation.adapters.MoviesAdapter
import me.joshshin.filmed.utils.FullScreenSwipeToDismissListener

class MoviesActivity : AppCompatActivity(){
    companion object {
        private var hasSeenIntroImage =  false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movies_activity)

        if (hasSeenIntroImage) {
            (intro_screen_container.parent as ViewGroup).removeView(intro_screen_container)
        } else {
            intro_screen_container.setOnTouchListener(FullScreenSwipeToDismissListener())
        }

        hasSeenIntroImage = true

        movies_recycler.adapter = MoviesAdapter(this)
        movies_recycler.layoutManager = LinearLayoutManager(this)
    }

}
