package joshshin.me.filmed.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Josh Shin on 4/15/18
 */

data class MoviesResponse(
        val page: Int?,
        @SerializedName("total_results")
        val totalResults: Int?,
        @SerializedName("total_pages")
        val totalPages: Int?,
        val results: List<Movie>?
)