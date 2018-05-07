package me.joshshin.filmed.presentation.adapters

import android.content.Context
import android.support.transition.TransitionManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_info_item.view.*
import me.joshshin.filmed.R
import me.joshshin.filmed.presentation.adapters.MoviesAdapter.MoviesViewHolder
import me.joshshin.domain.dataProvider.DataCallback
import me.joshshin.domain.dataProvider.DataCallbackException
import kotlinx.android.synthetic.main.movie_item.view.*
import me.joshshin.datalayer.network.FilmedApiConstants.BASE_IMAGE_URL
import me.joshshin.domain.models.FilmedMovie
import me.joshshin.filmed.FilmedConfig
import me.joshshin.filmed.utils.Logger
import me.joshshin.filmed.utils.runOnUiThread
import me.joshshin.filmed.utils.toggleVisibility

/**
 * Created by Josh Shin on 4/15/18
 */

class MoviesAdapter(private val context: Context) : RecyclerView.Adapter<MoviesViewHolder>() {
    private var movies: List<FilmedMovie> = listOf()
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]
        //TODO change image path i/r/t image size depending on screen density
        with(holder) {
            title.text = movie.title
            overview.text = movie.overview
            Picasso.get().load(BASE_IMAGE_URL + movie.backdropPath).into(image)
            itemView.setOnClickListener {
                infoContainer.toggleVisibility()
                TransitionManager.beginDelayedTransition(itemView.parent as ViewGroup)
            }
        }
    }

    private fun generateMoviesCallback(): DataCallback<FilmedMovie> {
        return object : DataCallback<FilmedMovie> {
            override fun onComplete(data: List<FilmedMovie>) {
                movies = data
                runOnUiThread { notifyDataSetChanged() }
            }
            override fun onError(error: DataCallbackException) {
                Toast.makeText(context, "Error downloading movies", Toast.LENGTH_LONG).show()
                Logger.e(this, "${error.message}")
            }
        }
    }

    private fun fetchMovies() {
        FilmedConfig.moviesProvider.provideData(generateMoviesCallback())
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        fetchMovies()
    }

    class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val infoContainer = view.info_container
        val overview = view.overview
        val title = view.title
        val image = view.backdrop_image
    }
}