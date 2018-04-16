package joshshin.me.filmed.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by Josh Shin on 4/15/18
 */

data class Movie(
        @SerializedName("vote_count")
        @Expose
        val voteCount: Int?,
        @Expose
        val id: Int?,
        @Expose
        val video: Boolean?,
        @SerializedName("vote_average")
        @Expose
        val voteAverage: Float?,
        @Expose
        val title: String?,
        @Expose
        val popularity: Float?,
        @SerializedName("poster_path")
        @Expose
        val posterPath: String,
        @SerializedName("backdrop_path")
        @Expose
        val backdropPath: String?,
        @Expose
        val overview: String?,
        @SerializedName("release_date")
        @Expose
        val releaseDate: Date?
)