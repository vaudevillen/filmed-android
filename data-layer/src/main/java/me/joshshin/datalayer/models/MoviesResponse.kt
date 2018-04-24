package me.joshshin.datalayer.models

import com.google.gson.annotations.SerializedName
import me.joshshin.domain.models.FilmedMoviesResponse

/**
 * Created by Josh Shin on 4/22/18
 */

data class MoviesResponse(
        override val page: Int?,
        @SerializedName("total_results")
        override val totalResults: Int?,
        @SerializedName("total_pages")
        override val totalPages: Int?,
        override val results: List<Movie>?
) : FilmedMoviesResponse