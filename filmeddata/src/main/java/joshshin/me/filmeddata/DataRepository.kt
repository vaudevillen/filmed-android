package joshshin.me.filmeddata

/**
 * Created by Josh Shin on 4/22/18
 */

abstract class DataRepository<out T> {
    abstract val provider: DataProvider<T>

    fun fetchData(callback: DataCallback<T>) {
        provider.provideData(callback)
    }
}