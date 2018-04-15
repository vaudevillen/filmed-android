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
        private val voteCount: Int?,
        @Expose
        private val id: Int,
        @Expose
        private val video: Boolean?,
        @SerializedName("vote_average")
        @Expose
        private val voteAverage: Float?,
        @SerializedName("title")
        @Expose
        private val title: String,
        @Expose
        private val popularity: Float?,
        @SerializedName("poster_path")
        @Expose
        private val posterPath: String,
        @SerializedName("backdrop_path")
        @Expose
        private val backdropPath: String,
        @Expose
        private val overview: String,
        @SerializedName("release_date")
        @Expose
        private val releaseDate: Date
)