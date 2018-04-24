package me.joshshin.filmeddomain.dataProvider

/**
 * Created by Josh Shin on 4/22/18
 */

interface DataCallback<in T> {
    fun onComplete(data: T)
    fun onError(error: DataCallbackException)
}

class DataCallbackException(override val message: String?) : Exception(message)