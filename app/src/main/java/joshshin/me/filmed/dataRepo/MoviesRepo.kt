package joshshin.me.filmed.dataRepo

import android.arch.lifecycle.ViewModel
import joshshin.me.filmeddata.DataCallback
import joshshin.me.filmeddata.DataRepository
import joshshin.me.filmeddomain.models.FilmedMovie
import org.threeten.bp.Instant
import org.threeten.bp.temporal.ChronoField

/**
 * Created by Josh Shin on 4/22/18
 */

class MoviesRepo : DataRepository<List<FilmedMovie>>, ViewModel() {
    companion object {
        const val FIVE_MINUTES = 5 * 60 * 1000
    }

    var movies: List<FilmedMovie> = listOf()

    private var lastUpdate = Instant.now().getLong(ChronoField.MILLI_OF_SECOND)

    override val provider = MoviesProvider()

    private fun isUpdateTimeExpired(): Boolean {
        val now = Instant.now().getLong(ChronoField.MILLI_OF_SECOND)
        val timeElapsed = now - lastUpdate
        return timeElapsed > FIVE_MINUTES
    }

    fun getMovies(callback: DataCallback<List<FilmedMovie>>) {
        if (movies.isEmpty() || isUpdateTimeExpired()) {
            fetchData(callback)
        } else {
            callback.onComplete(movies)
        }
    }

    fun refreshMovies(callback: DataCallback<List<FilmedMovie>>) {
        fetchData(callback)
    }

}