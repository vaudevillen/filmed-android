package me.joshshin.filmed.dataRepo

import android.arch.lifecycle.ViewModel
import me.joshshin.filmeddata.DataCallback
import me.joshshin.filmeddata.DataRepository
import me.joshshin.filmeddomain.models.Movie
import org.threeten.bp.Instant
import org.threeten.bp.temporal.ChronoField

/**
 * Created by Josh Shin on 4/22/18
 */

class MoviesRepo : DataRepository<List<Movie>>, ViewModel() {
    companion object {
        const val FIVE_MINUTES = 5 * 60 * 1000
    }

    private var movies: List<Movie> = listOf()

    override val provider = MoviesProvider()

    private var lastUpdate = Instant.now().getLong(ChronoField.MILLI_OF_SECOND)

    private fun isUpdateTimeExpired(): Boolean {
        val now = Instant.now().getLong(ChronoField.MILLI_OF_SECOND)
        val timeElapsed = now - lastUpdate
        return timeElapsed > FIVE_MINUTES
    }

    fun getMovies(callback: DataCallback<List<Movie>>) {
        if (movies.isEmpty() || isUpdateTimeExpired()) {
            fetchData(callback)
        } else {
            callback.onComplete(movies)
        }
    }

    fun refreshMovies(callback: DataCallback<List<Movie>>) {
        fetchData(callback)
    }

}