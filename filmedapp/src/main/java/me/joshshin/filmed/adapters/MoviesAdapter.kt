package me.joshshin.filmed.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import me.joshshin.filmed.R
import me.joshshin.filmed.adapters.MoviesAdapter.MoviesViewHolder
import me.joshshin.filmeddomain.dataProvider.DataCallback
import me.joshshin.filmeddomain.dataProvider.DataCallbackException
import kotlinx.android.synthetic.main.movie_item.view.*
import me.joshshin.filmed.BuildConfig
import me.joshshin.datalayer.MoviesProvider
import me.joshshin.datalayer.network.FilmedApiConstants.BASE_IMAGE_URL
import me.joshshin.filmeddomain.models.FilmedMovie

/**
 * Created by Josh Shin on 4/15/18
 */

class MoviesAdapter(private val context: Context) : RecyclerView.Adapter<MoviesViewHolder>() {
    private var movies: List<FilmedMovie> = listOf()

    private val moviesProvider = MoviesProvider()

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

    private fun generateMoviesCallback(): DataCallback<List<FilmedMovie>> {
        return object : DataCallback<List<FilmedMovie>> {
            override fun onComplete(data: List<FilmedMovie>) {
                movies = data
                notifyDataSetChanged()
            }
            override fun onError(error: DataCallbackException) {
                Toast.makeText(context, "Error downloading movies", Toast.LENGTH_LONG).show()
                if (BuildConfig.DEBUG) {
                    Log.e("Fetch Movies", error.message)
                }
            }
        }
    }
    private fun fetchMovies() {
        moviesProvider.provideData(generateMoviesCallback())
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        fetchMovies()
    }

    class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view)
}