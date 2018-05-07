package me.joshshin.domain.dataProvider

/**
 * Created by Josh Shin on 4/22/18
 */

interface DataCallback<T> {
    fun onComplete(data: List<T>)
    fun onError(error: DataCallbackException)
}

class DataCallbackException(override val message: String?) : Exception(message)