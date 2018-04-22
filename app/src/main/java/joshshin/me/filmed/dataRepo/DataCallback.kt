package joshshin.me.filmed.dataRepo

/**
 * Created by Josh Shin on 4/22/18
 */

interface DataCallback<T> {
    fun onComplete(movies: T)
    fun onError(error: Exception)
}