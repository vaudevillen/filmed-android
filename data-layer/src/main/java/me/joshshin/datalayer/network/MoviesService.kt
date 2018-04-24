package me.joshshin.datalayer.network

import me.joshshin.datalayer.models.MoviesResponse
import me.joshshin.datalayer.network.FilmedApiConstants.POPULAR_MOVIES_PATH
import me.joshshin.datalayer.network.FilmedApiConstants.SEARCH_MOVIES_PATH
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Josh Shin on 4/15/18
 */

interface  MoviesService {
    @GET(POPULAR_MOVIES_PATH)
    fun getPopularMovies(): Call<MoviesResponse>

    @GET(SEARCH_MOVIES_PATH)
    fun searchMovies(@Query("query") query: String) : Call<MoviesResponse>
}