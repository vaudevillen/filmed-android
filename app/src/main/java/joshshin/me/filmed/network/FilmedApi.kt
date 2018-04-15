package joshshin.me.filmed.network

import joshshin.me.filmed.models.MoviesResponse
import retrofit2.Callback

/**
 * Created by Josh Shin on 4/15/18
 */

interface FilmedApi {
    fun fetchPopularMovies(callback: Callback<MoviesResponse>)
    fun searchMovies(query: String)
}