package joshshin.me.filmeddata

/**
 * Created by Josh Shin on 4/22/18
 */

interface DataRepository<out T> {
    val provider: DataProvider<T>

    fun fetchData(callback: DataCallback<T>) {
        provider.provideData(callback)
    }
}