package joshshin.me.filmed.dataRepo

import joshshin.me.filmed.models.MoviesResponse
import joshshin.me.filmed.network.FilmedApi
import joshshin.me.filmed.network.MoviesService
import joshshin.me.filmeddata.DataCallback
import joshshin.me.filmeddata.DataCallbackException
import joshshin.me.filmeddata.DataProvider
import joshshin.me.filmeddomain.models.FilmedMovie
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