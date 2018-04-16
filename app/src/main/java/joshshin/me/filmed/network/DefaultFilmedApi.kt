package joshshin.me.filmed.network

import joshshin.me.filmed.BuildConfig
import joshshin.me.filmed.models.MoviesResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

/**
 * Created by Josh Shin on 4/15/18
 */

class DefaultFilmedApi() : FilmedApi {
    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/"
        private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/"

        private val loggingInterceptor =
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BASIC
                }

        private val client by lazy {
            if (BuildConfig.DEBUG) {
                OkHttpClient.Builder()
                        .addInterceptor(loggingInterceptor)
                        .build()
            } else {
                OkHttpClient()
            }
        }

        private val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // this looks like overkill, but adding this method just in case there's another kind of service
        private fun <S> createService(clazz: Class<S>): S {
            return retrofit.create(clazz)
        }

        private val moviesService = createService(MoviesService::class.java)
    }

    override fun fetchPopularMovies(callback: Callback<MoviesResponse>) {
        moviesService.getPopularMovies().enqueue(callback)
    }

    override fun searchMovies(query: String, callback: Callback<MoviesResponse>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}