package me.joshshin.filmed.presentation.adapters

import android.arch.lifecycle.Observer
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*
import me.joshshin.datalayer.network.FilmedApiConstants.BASE_IMAGE_URL
import me.joshshin.domain.data.DataState
import me.joshshin.domain.models.FilmedMovie
import me.joshshin.filmed.R
import me.joshshin.filmed.presentation.adapters.MoviesAdapter.MoviesViewHolder

/**
 * Created by Josh Shin on 4/15/18
 */

class MoviesAdapter : RecyclerView.Adapter<MoviesViewHolder>() {

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
    }

    class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view)
}