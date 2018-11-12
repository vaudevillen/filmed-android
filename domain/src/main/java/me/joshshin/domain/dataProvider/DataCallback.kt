package me.joshshin.domain.dataProvider

/**
 * Created by Josh Shin on 4/22/18
 */

interface DataCallback<in D> {
    fun onComplete(data: D)
    fun onError(error: DataCallbackException)
}

class DataCallbackException(override val message: String?) : Exception(message)