package me.joshshin.filmed.dataRepo

import me.joshshin.filmed.network.FilmedApi
import me.joshshin.filmed.network.MoviesService
import me.joshshin.filmeddata.DataCallback
import me.joshshin.filmeddata.DataCallbackException
import me.joshshin.filmeddata.DataProvider
import me.joshshin.filmeddomain.models.Movie
import me.joshshin.filmeddomain.models.MoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Josh Shin on 4/21/18
 */

class MoviesProvider : DataProvider<List<Movie>> {
    private val moviesClient = FilmedApi.createService<MoviesService>()

    override fun provideData(callback: DataCallback<List<Movie>>) {
        moviesClient.getPopularMovies().enqueue(object : Callback<MoviesResponse> {
            override fun onFailure(call: Call<MoviesResponse>?, t: Throwable?) {
                callback.onError(MovieProviderException(t?.message?: "api failure"))
            }

            override fun onResponse(call: Call<MoviesResponse>?, response: Response<MoviesResponse>?) {
                if (response?.body()?.results != null) {
                    val moviesResponse = response.body()
                    moviesResponse?.results?.let {
                        callback.onComplete(it)
                    }
                } else {
                    callback.onError(MovieProviderException("MoviesResponse or MoviesResponse.results was null"))
                }
            }
        })
    }
}

class MovieProviderException(message: String) : Exception(message), DataCallbackException