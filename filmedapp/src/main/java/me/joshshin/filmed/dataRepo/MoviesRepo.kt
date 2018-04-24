package me.joshshin.filmed.dataRepo

import android.arch.lifecycle.ViewModel
import me.joshshin.datalayer.DataCallback
import me.joshshin.datalayer.DataRepository
import me.joshshin.filmeddomain.models.FilmedMovie

/**
 * Created by Josh Shin on 4/22/18
 */

// TODO have this implement ViewModel goodness so data survives configuration changes.
class MoviesRepo : DataRepository<List<FilmedMovie>>, ViewModel() {
    private var movies: List<FilmedMovie> = listOf()

    override val provider = MoviesProvider()

    fun getMovies(callback: DataCallback<List<FilmedMovie>>) {
        // TODO I'm not totally a fan of how this is looking so far...
        fetchData(callback)
    }
}