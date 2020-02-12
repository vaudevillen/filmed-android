package me.joshshin.filmed.presentation.movies

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import me.joshshin.domain.data.DataState
import me.joshshin.domain.models.FilmedMovie
import me.joshshin.filmed.R
import me.joshshin.filmed.presentation.movies.MoviesAdapter.MoviesViewHolder

/**
 * Created by Josh Shin on 4/15/18
 */

class MoviesAdapter(
        private val context: Context,
        private val moviesViewModel: MoviesViewModel,
        private val scope: CoroutineScope
) : RecyclerView.Adapter<MoviesViewHolder>(), CoroutineScope by scope {

    private var movies: List<FilmedMovie> = emptyList()
        set(value) {
            if (field != value) {
                field = value
                notifyDataSetChanged()
            }
        }

    private var selectedMoviePosition: Int? = null
        set(value) {
            when {
                // new movie selected
                value != null && value != field -> {
                    field = value
                    notifyItemChanged(value)
                }
                value != null && value == field -> {
                    // unset selected item
                    field = null
                    notifyItemChanged(value)
                }
            }
        }

    init {
        launch {
            moviesViewModel.moviesChannel.consumeEach { dataState: DataState ->
                when (dataState) {
                    // Due to type erasure, can't see the type.
                    // But it's gonna be a [List<FilmedMovie>]
                    is DataState.Success<*> -> {
                        // TODO hide loading indicator
                        movies = dataState.data as List<FilmedMovie>
                    }
                    is DataState.Loading<*> -> {
                        dataState.cachedValue?.let {
                            movies = it as List<FilmedMovie>
                        }
                        //TODO show loading indicator
                    }
                    is DataState.Error -> {

                        // TODO show error message
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]
        with(holder.moviePresenter) {
            // TODO fix nullability
            setTitle(movie.title!!)
            setOverview(movie.overview!!)
            updatePoster(movie.backdropPath!!)

            // TODO figure out ui enlarge/shrink stuff
            holder.itemView.setOnClickListener {
                selectedMoviePosition = position
            }
        }
    }

    class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val moviePresenter = MoviePresenterView(view)
    }
}