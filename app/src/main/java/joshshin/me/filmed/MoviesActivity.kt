package joshshin.me.filmed

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import joshshin.me.filmed.adapters.MoviesAdapter
import kotlinx.android.synthetic.main.movies_activity.*

class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movies_activity)

        movies_recycler.adapter = MoviesAdapter(this)
        movies_recycler.layoutManager = LinearLayoutManager(this)
        // TODO add itemDecorator to add margins between items. get rid of padding in [movie_item]
    }
}
