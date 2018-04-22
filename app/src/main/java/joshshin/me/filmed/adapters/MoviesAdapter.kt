package joshshin.me.filmed.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import joshshin.me.filmed.FilmedConstants.BASE_IMAGE_URL
import joshshin.me.filmed.R
import joshshin.me.filmed.adapters.MoviesAdapter.MoviesViewHolder
import joshshin.me.filmed.models.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

/**
 * Created by Josh Shin on 4/15/18
 */

class MoviesAdapter(private val context: Context) : RecyclerView.Adapter<MoviesViewHolder>() {
    private var movies: List<Movie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]
        //TODO change image path i/r/t image size depending on screen density
        Picasso.get().load(BASE_IMAGE_URL + movie.backdropPath).into(holder.itemView.backdrop_image)
    }

    class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view)
}