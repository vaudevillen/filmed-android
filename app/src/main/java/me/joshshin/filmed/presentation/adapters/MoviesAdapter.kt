package me.joshshin.filmed.presentation.adapters

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*
import me.joshshin.datalayer.network.FilmedApiConstants.BASE_IMAGE_URL
import me.joshshin.domain.models.FilmedMovie
import me.joshshin.filmed.R
import me.joshshin.filmed.presentation.MoviesViewModel
import me.joshshin.filmed.presentation.adapters.MoviesAdapter.MoviesViewHolder

/**
 * Created by Josh Shin on 4/15/18
 */

class MoviesAdapter(
        private val lifecycleOwner: LifecycleOwner,
        private val moviesViewModel: MoviesViewModel
) : RecyclerView.Adapter<MoviesViewHolder>() {

    var movies: List<FilmedMovie> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]
        //TODO change image path i/r/t image size depending on screen density
        Picasso.get().load(BASE_IMAGE_URL + movie.backdropPath).into(holder.itemView.backdrop_image)
        moviesViewModel.selectedMoviePosition.observe(lifecycleOwner, holder.selectedMovieObserver)
    }

    class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val selectedMovieObserver: Observer<Int> = Observer {
            it ?: return@Observer
            //TODO expand movie image
        }
    }
}