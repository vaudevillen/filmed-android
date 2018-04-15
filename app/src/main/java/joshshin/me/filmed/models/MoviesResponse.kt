package joshshin.me.filmed.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Josh Shin on 4/15/18
 */

data class MoviesResponse(
        @SerializedName("page")
        @Expose
        private val page: Int?,
        @SerializedName("total_results")
        @Expose
        private val totalResults: Int?,
        @SerializedName("total_pages")
        @Expose
        private val totalPages: Int?,
        @SerializedName("results")
        @Expose
        private val movies: List<Movie>?
)