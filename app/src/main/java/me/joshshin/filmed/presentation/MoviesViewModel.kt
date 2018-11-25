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

    val selectedMoviePosition = MutableLiveData<Pair<Int, Int>>()
            .apply { value = -1 to -1 }

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
        val oldPositions = selectedMoviePosition.value!!
        val previousSelection = oldPositions.second
        if (previousSelection != position) {
            selectedMoviePosition.value = oldPositions.second to position
        } else {
            selectedMoviePosition.value = oldPositions.second to -1
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