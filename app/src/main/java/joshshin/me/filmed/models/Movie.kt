package joshshin.me.filmed.models

import com.google.gson.annotations.SerializedName
import joshshin.me.filmeddomain.models.FilmedMovie
import java.util.*

/**
 * Created by Josh Shin on 4/15/18
 */

data class Movie(
        @SerializedName("vote_count")
        override val voteCount: Int?,
        override val id: Int?,
        override val video: Boolean?,
        @SerializedName("vote_average")
        override val voteAverage: Float?,
        override val title: String?,
        override val popularity: Float?,
        @SerializedName("poster_path")
        override val posterPath: String,
        @SerializedName("backdrop_path")
        override val backdropPath: String?,
        override val overview: String?,
        @SerializedName("release_date")
        override val releaseDate: Date?
) : FilmedMovie