package me.joshshin.filmed.presentation.movies

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.ViewGroup
import kotlinx.android.synthetic.main.filmed_intro_screen.*
import kotlinx.android.synthetic.main.movies_recycler.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import me.joshshin.filmed.R
import me.joshshin.filmed.presentation.FullScreenSwipeToDismissListener
import me.joshshin.filmed.presentation.SpaceItemDecoration

class MoviesActivity : AppCompatActivity(){
    companion object {
        // TODO set this back
        private var hasSeenIntroImage =  true
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

        val moviesViewModel = ViewModelProviders.of(this)[MoviesViewModel::class.java]

        // TODO fix this scope.
        val scope = CoroutineScope(Dispatchers.Main + Job())
        val moviesAdapter = MoviesAdapter(this, moviesViewModel, scope)
        movies_recycler.adapter = moviesAdapter
        movies_recycler.layoutManager = LinearLayoutManager(this)
        movies_recycler.addItemDecoration(
                SpaceItemDecoration(this, this.resources.getDimension(R.dimen.margin_xsmall))
        )
    }
}
