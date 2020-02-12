package me.joshshin.domain.data

/**
 * Created by Josh Shin on 11/11/18
 */

interface DataCallback<D> {
    fun onComplete(t: D)
    fun onError(exception: DataCallbackException)
}