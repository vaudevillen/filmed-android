package me.joshshin.filmed.presentation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import me.joshshin.domain.data.DataState
import me.joshshin.domain.models.FilmedMovie
import me.joshshin.filmed.FilmedConfig

/**
 * Created by Josh Shin on 11/11/18
 */

class MoviesViewModel : ViewModel() {

    val moviesLiveData = MutableLiveData<DataState<List<FilmedMovie>>>()

    /**
     * Contains a pair of the previous and new selected movies.
     * The first number is the previously selected position.
     * The second number is the newly selected position.
     *
     * Initialized with a values of -1
     */
    val selectedMoviePositions = MutableLiveData<Pair<Int, Int>>().apply { value = -1 to -1 }

    fun getMovies() {
        if (moviesLiveData.value == null) {
            moviesLiveData.value = DataState(DataState.State.Loading)
            fetchMovies()
        } else {
            // just setting off a call to trigger the observer by reposting the value
            moviesLiveData.value = moviesLiveData.value
        }
    }

    fun selectMovie(position: Int) {
        val oldPosiiton = selectedMoviePositions.value!!.second
        if (oldPosiiton != position) {
            // User selected a new movie
            selectedMoviePositions.value = oldPosiiton to position
        } else {
            // User unselected the movie
            selectedMoviePositions.value = oldPosiiton to -1
        }
    }

    private fun fetchMovies() {
        FilmedConfig.moviesProvider.provideData(
                doOnComplete = {
                    moviesLiveData.value = DataState(DataState.State.Success, it)
                },
                doOnError = {
                    moviesLiveData.value = DataState(DataState.State.Error(0), null)
                }
        )
    }
}