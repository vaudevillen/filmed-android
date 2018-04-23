package joshshin.me.filmed.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import joshshin.me.filmed.FilmedConstants.BASE_IMAGE_URL
import joshshin.me.filmed.R
import joshshin.me.filmed.adapters.MoviesAdapter.MoviesViewHolder
import joshshin.me.filmed.dataRepo.MoviesRepo
import joshshin.me.filmed.models.Movie
import joshshin.me.filmeddata.DataCallback
import joshshin.me.filmeddata.DataCallbackException
import kotlinx.android.synthetic.main.movie_item.view.*

/**
 * Created by Josh Shin on 4/15/18
 */

class MoviesAdapter(private val context: Context, private val repo: MoviesRepo) : RecyclerView.Adapter<MoviesViewHolder>() {
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

    private fun generateMoviesCallback(): DataCallback<List<Movie>> {
        return object : DataCallback<List<Movie>> {
            override fun onComplete(data: List<Movie>) {
                movies = data
                notifyDataSetChanged()
            }
            override fun onError(error: DataCallbackException) {
                Toast.makeText(context, "Error downloading movies", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun fetchMovies() {
        repo.getMovies(generateMoviesCallback())
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        fetchMovies()
    }

    class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view)
}