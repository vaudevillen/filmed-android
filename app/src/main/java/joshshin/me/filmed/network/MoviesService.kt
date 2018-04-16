package joshshin.me.filmed.network

import joshshin.me.filmed.FilmedConstants.POPULAR_MOVIES_PATH
import joshshin.me.filmed.FilmedConstants.SEARCH_MOVIES_PATH
import joshshin.me.filmed.models.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Josh Shin on 4/15/18
 */

interface MoviesService {
    @GET(POPULAR_MOVIES_PATH)
    fun getPopularMovies(): Call<MoviesResponse>

    @GET(SEARCH_MOVIES_PATH)
    fun searchMovies(@Query("query") query: String) : Call<MoviesResponse>
}