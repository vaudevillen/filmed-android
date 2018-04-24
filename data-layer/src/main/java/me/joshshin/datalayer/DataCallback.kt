package me.joshshin.datalayer

/**
 * Created by Josh Shin on 4/22/18
 */

interface DataCallback<in T> {
    fun onComplete(data: T)
    fun onError(error: DataCallbackException)
}

interface DataCallbackException