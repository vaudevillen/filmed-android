package joshshin.me.filmed.network

/**
 * Created by Josh Shin on 4/15/18
 */

interface FilmedApi {
    fun fetchPopularMovies()
    fun searchMovies(query: String)
}