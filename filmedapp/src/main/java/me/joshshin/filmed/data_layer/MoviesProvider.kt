package me.joshshin.filmed.data_layer

import me.joshshin.datalayer.DataCallback
import me.joshshin.datalayer.DataCallbackException
import me.joshshin.datalayer.DataProvider
import me.joshshin.filmed.models.MoviesResponse
import me.joshshin.filmed.network.FilmedApi
import me.joshshin.filmed.network.MoviesService
import me.joshshin.filmeddomain.models.FilmedMovie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Josh Shin on 4/21/18
 */

class MoviesProvider : DataProvider<List<FilmedMovie>> {
    private val moviesClient = FilmedApi.createService<MoviesService>()

    override fun provideData(callback: DataCallback<List<FilmedMovie>>) {
        moviesClient.getPopularMovies().enqueue(object : Callback<MoviesResponse> {
            override fun onFailure(call: Call<MoviesResponse>?, t: Throwable?) {
                callback.onError(DataCallbackException(t?.message
                        ?: "api failure"))
            }

            override fun onResponse(call: Call<MoviesResponse>?, response: Response<MoviesResponse>?) {
                if (response?.body()?.results != null) {
                    val moviesResponse = response.body()
                    moviesResponse?.results?.let {
                        callback.onComplete(it)
                    }
                } else {
                    callback.onError(DataCallbackException("FilmedMoviesResponse or FilmedMoviesResponse.results was null"))
                }
            }
        })
    }
}

