package me.joshshin.filmed

/**
 * Created by Josh Shin on 4/15/18
 */

internal object FilmedConstants {
    const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w780/"
    const val BASE_URL = "https://api.themoviedb.org/"
    private const val API_VERSION = "3/"
    // TODO rethink how janky putting in the api key is
    const val POPULAR_MOVIES_PATH = "${API_VERSION}movie/popular?api_key=${BuildConfig.API_KEY}"
    const val SEARCH_MOVIES_PATH = "${API_VERSION}search/movie?api_key=${BuildConfig.API_KEY}"
}