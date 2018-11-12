package me.joshshin.domain.data

/**
 * Created by Josh Shin on 11/11/18
 */

interface DataProvider<D> {
    var onProvideSuccess: (D) -> Unit
    var onProvideError: (String) -> Unit

    fun provideData()
}