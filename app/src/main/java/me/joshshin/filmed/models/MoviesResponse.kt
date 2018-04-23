package me.joshshin.filmed.models

import com.google.gson.annotations.SerializedName
import me.joshshin.filmeddomain.models.FilmedMoviesResponse

/**
 * Created by Josh Shin on 4/15/18
 */

data class MoviesResponse(
        override val page: Int?,
        @SerializedName("total_results")
        override val totalResults: Int?,
        @SerializedName("total_pages")
        override val totalPages: Int?,
        override val results: List<Movie>?
) : FilmedMoviesResponse