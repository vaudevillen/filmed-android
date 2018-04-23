package me.joshshin.filmeddata

/**
 * Created by Josh Shin on 4/22/18
 */

interface DataProvider<out T> {
    fun provideData(callback: DataCallback<T>)
}