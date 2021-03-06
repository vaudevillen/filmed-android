package me.joshshin.datalayer

import me.joshshin.datalayer.models.MoviesResponse
import me.joshshin.datalayer.network.FilmedApi
import me.joshshin.datalayer.network.MoviesService
import me.joshshin.domain.data.DataCallback
import me.joshshin.domain.data.DataCallbackException
import me.joshshin.domain.data.DataProvider
import me.joshshin.domain.models.FilmedMovie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Josh Shin on 4/21/18
 */

object MoviesProvider: DataProvider<List<FilmedMovie>>() {

    private val moviesClient = FilmedApi.createService<MoviesService>()

    override fun provideData(callback: DataCallback<List<FilmedMovie>>) {
        moviesClient.getPopularMovies().enqueue(object : Callback<MoviesResponse> {
            override fun onFailure(call: Call<MoviesResponse>?, t: Throwable?) {
                val exception = DataCallbackException(t?.message
                        ?: "api failure")
                callback.onError(exception)
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

