package joshshin.me.filmed.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Josh Shin on 4/15/18
 */

data class MoviesResponse(
        @Expose
        val page: Int?,
        @SerializedName("total_results")
        @Expose
        val totalResults: Int?,
        @SerializedName("total_pages")
        @Expose
        val totalPages: Int?,
        @Expose
        val results: List<Movie>?
)