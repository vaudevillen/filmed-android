package joshshin.me.filmed.network

import joshshin.me.filmed.models.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Josh Shin on 4/15/18
 */

interface MoviesService {
    // TODO get rid of this api_key query and add it in an interceptor
    @GET("3/movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Call<MoviesResponse>
}