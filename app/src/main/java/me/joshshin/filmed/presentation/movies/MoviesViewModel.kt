package me.joshshin.filmed.presentation.movies

import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import me.joshshin.domain.data.DataState
import me.joshshin.domain.models.FilmedMovie
import me.joshshin.filmed.FilmedConfig

/**
 * Created by Josh Shin on 11/11/18
 */

class MoviesViewModel : ViewModel() {
    val moviesChannel = ConflatedBroadcastChannel<DataState>()

    init {
        getMovies()
    }

    private fun setLoadingState() {
        val state = if (moviesChannel.valueOrNull != null && moviesChannel.valueOrNull is DataState.Success<*>) {
            val previousState = moviesChannel.value as DataState.Success<List<FilmedMovie>>
            DataState.Loading(previousState.data)
        } else {
            DataState.Loading(null)
        }
        moviesChannel.offer(state)
    }

    fun getMovies() {
        setLoadingState()

        FilmedConfig.moviesProvider.provideData(
                doOnComplete = {
                    moviesChannel.offer(DataState.Success(it))
                },
                doOnError = {
                    val error = DataState.Error(
                            code = 0,
                            message = "Error",
                            error = it
                        )
                    // TODO put real message in variable
                    moviesChannel.offer(error)
                }
        )
    }
}
