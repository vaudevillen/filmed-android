package me.joshshin.filmed

import me.joshshin.datalayer.MoviesProvider
import me.joshshin.domain.data.DataProvider
import me.joshshin.domain.models.FilmedMovie

/**
 * Created by Josh Shin on 11/11/18
 *
 * Wiring for connecting the data-layer to the app-layer.
 */

object FilmedConfig {
    val moviesProvider: DataProvider<List<FilmedMovie>> = MoviesProvider
}