package me.joshshin.filmed

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.filmed_intro_screen.*
import kotlinx.android.synthetic.main.movies_recycler.*
import me.joshshin.filmed.adapters.MoviesAdapter
import me.joshshin.filmed.utils.setGone

class MoviesActivity : AppCompatActivity(){
    companion object {
        private var hasSeenIntroImage =  false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movies_activity)

        if (hasSeenIntroImage) {
            intro_screen_container.setGone()
        } else {
            intro_screen_container.setOnTouchListener(FullScreenSwipeToDismissListener())
        }

        hasSeenIntroImage = true

        movies_recycler.adapter = MoviesAdapter(this)
        movies_recycler.layoutManager = LinearLayoutManager(this)
        movies_recycler.addItemDecoration(
                SpaceItemDecoration(this, this.resources.getDimension(R.dimen.margin_xsmall))
        )
    }

}
