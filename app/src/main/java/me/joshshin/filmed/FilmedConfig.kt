package me.joshshin.filmed

import me.joshshin.datalayer.MoviesProvider
import me.joshshin.domain.dataProvider.DataProvider
import me.joshshin.domain.models.FilmedMovie

/**
 * Created by Josh Shin on 4/27/18
 */

object FilmedConfig {
    val moviesProvider: DataProvider<FilmedMovie> = MoviesProvider()
}