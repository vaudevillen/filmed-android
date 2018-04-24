package me.joshshin.filmed.network

import me.joshshin.filmed.network.FilmedApiConstants.POPULAR_MOVIES_PATH
import me.joshshin.filmed.network.FilmedApiConstants.SEARCH_MOVIES_PATH
import me.joshshin.filmeddomain.models.FilmedMoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Josh Shin on 4/15/18
 */

interface  MoviesService {
    @GET(POPULAR_MOVIES_PATH)
    fun getPopularMovies(): Call<FilmedMoviesResponse>

    @GET(SEARCH_MOVIES_PATH)
    fun searchMovies(@Query("query") query: String) : Call<FilmedMoviesResponse>
}