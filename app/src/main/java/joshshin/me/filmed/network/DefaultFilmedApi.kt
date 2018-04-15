package joshshin.me.filmed.network

import joshshin.me.filmed.BuildConfig

/**
 * Created by Josh Shin on 4/15/18
 */

class DefaultFilmedApi() {
    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3"
        private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/"
        private val apiKey = BuildConfig.API_KEY
    }
}