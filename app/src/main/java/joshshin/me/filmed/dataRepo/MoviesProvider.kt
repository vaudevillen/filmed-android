package joshshin.me.filmed.dataRepo

import android.arch.lifecycle.LifecycleOwner
import joshshin.me.filmed.models.Movie
import joshshin.me.filmed.models.MoviesResponse
import joshshin.me.filmed.network.FilmedApi
import joshshin.me.filmed.network.MoviesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Josh Shin on 4/21/18
 */

class MoviesProvider(private val lifecycleOwner: LifecycleOwner) {
    private val moviesClient = FilmedApi.createService<MoviesService>()

    fun provideMovies(dataCallback: DataCallback<List<Movie>>) {
        moviesClient.getPopularMovies().enqueue(object : Callback<MoviesResponse> {
            override fun onFailure(call: Call<MoviesResponse>?, t: Throwable?) {
                dataCallback.onError(MovieProviderException(t?.message?: "api failure"))
            }

            override fun onResponse(call: Call<MoviesResponse>?, response: Response<MoviesResponse>?) {
                if (response?.body()?.results != null) {
                    val moviesResponse = response.body()
                    moviesResponse?.results?.let {
                        dataCallback.onComplete(it)
                    }
                } else {
                    dataCallback.onError(MovieProviderException("MoviesResponse or MoviesResponse.results was null"))
                }
            }
        })
    }
}

class MovieProviderException(message: String) : Exception(message)