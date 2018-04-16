package joshshin.me.filmed.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by Josh Shin on 4/15/18
 */

data class Movie(
        @SerializedName("vote_count")
        val voteCount: Int?,
        val id: Int?,
        val video: Boolean?,
        @SerializedName("vote_average")
        val voteAverage: Float?,
        val title: String?,
        val popularity: Float?,
        @SerializedName("poster_path")
        val posterPath: String,
        @SerializedName("backdrop_path")
        val backdropPath: String?,
        val overview: String?,
        @SerializedName("release_date")
        val releaseDate: Date?
)