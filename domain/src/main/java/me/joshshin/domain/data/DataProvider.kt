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
     * Further lambda convenience.
     * This wraps up all the convenience of above. You can feed the [onComplete]
     * and [onError] lambdas as arguments, and it'll call your [provideData]
     * function as well.
     */
    fun provideData(doOnComplete: (D) -> Unit, doOnError: (DataCallbackException) -> Unit) {
        val callback = object : DataCallback<D> {
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