package me.joshshin.filmeddomain.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Josh Shin on 4/22/18
 */

data class MoviesResponse(
        val page: Int?,
        @SerializedName("total_results")
        val totalResults: Int?,
        @SerializedName("total_pages")
        val totalPages: Int?,
        val results: List<Movie>?
)