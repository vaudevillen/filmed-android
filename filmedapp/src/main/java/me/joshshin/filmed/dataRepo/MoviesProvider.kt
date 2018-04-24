package me.joshshin.filmed.dataRepo

import me.joshshin.datalayer.DataCallback
import me.joshshin.datalayer.DataCallbackException
import me.joshshin.datalayer.DataProvider
import me.joshshin.filmed.network.FilmedApi
import me.joshshin.filmed.network.MoviesService
import me.joshshin.filmeddomain.models.FilmedMovie
import me.joshshin.filmeddomain.models.FilmedMoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Josh Shin on 4/21/18
 */

class MoviesProvider : DataProvider<List<FilmedMovie>> {
    private val moviesClient = FilmedApi.createService<MoviesService>()

    override fun provideData(callback: DataCallback<List<FilmedMovie>>) {
        moviesClient.getPopularMovies().enqueue(object : Callback<FilmedMoviesResponse> {
            override fun onFailure(call: Call<FilmedMoviesResponse>?, t: Throwable?) {
                callback.onError(MovieProviderException(t?.message
                        ?: "api failure"))
            }

            override fun onResponse(call: Call<FilmedMoviesResponse>?, response: Response<FilmedMoviesResponse>?) {
                if (response?.body()?.results != null) {
                    val moviesResponse = response.body()
                    moviesResponse?.results?.let {
                        callback.onComplete(it)
                    }
                } else {
                    callback.onError(MovieProviderException("FilmedMoviesResponse or FilmedMoviesResponse.results was null"))
                }
            }
        })
    }
}

class MovieProviderException(message: String) : Exception(message), DataCallbackException