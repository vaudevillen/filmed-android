package me.joshshin.domain.data

/**
 * Created by Josh Shin on 11/11/18
 */

abstract class DataProvider<D> {

    /**
     * For a little bit of lambda convenience.
     * Set what you want to happen when getting the data
     * is successful.
     */
    open var onComplete: (D) -> Unit = { /* no-op */ }

    /**
     * For a little bit of lambda convenience.
     * Set what you want to happen when
     * there's an error getting the data
     */
    open var onError: (String) -> Unit = { /* no-op */ }

    /**
     * Implementation details of getting the data goes here.
     */
    abstract fun provideData()

    /**
     * Further lambda convenience.
     * This wraps up all the convenience of above. You can feed the [onComplete]
     * and [onError] lambdas as arguments, and it'll call your [provideData]
     * function as well.
     */
    fun provideData(onComplete: (D) -> Unit, onError: (String) -> Unit) {
        this.onComplete = onComplete
        this.onError = onError
        provideData()
    }
}