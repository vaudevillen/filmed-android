package me.joshshin.domain.data

/**
 * Created by Josh Shin on 11/11/18
 */

abstract class DataProvider<D> {

    /**
     * Implementation details of getting the data goes here.
     */
    abstract fun provideData(callback: DataCallback<D>)

    /**
     * Lambda convenience.
     * You can feed the [onComplete] and [onError] lambdas as arguments,
     * and it'll create the [DataCallback] for you and call your
     * [provideData] function as well.
     */
    fun provideData(onComplete: (D) -> Unit, onError: (DataCallbackException) -> Unit) {
        val callback = object : DataCallback<D> {
            inline fun doOnComplete(d: D) = onComplete
            inline fun doOnError(exception: DataCallbackException) = onError

            override fun onComplete(t: D) {
                doOnComplete(t)
            }
            override fun onError(exception: DataCallbackException) {
                doOnError(exception)
            }
        }

        provideData(callback)
    }
}