package joshshin.me.filmed.network

import joshshin.me.filmed.BuildConfig
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



/**
 * Created by Josh Shin on 4/15/18
 */

class DefaultFilmedApi() : FilmedApi {
    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3"
        private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/"
        private val apiKey = BuildConfig.API_KEY

        private val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // this looks like overkill, but adding this method just in case there's another kind of service
        private fun <S> createService(clazz: Class<S>): S {
            return retrofit.create(clazz)
        }

        //private fun moviesService = createService()
    }

    override fun fetchPopularMovies() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchMovies(query: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}