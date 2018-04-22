package joshshin.me.filmed.models

import android.os.Parcel
import android.os.Parcelable
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
) : FilmedMovie, Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readInt(),
                parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
                parcel.readFloat(),
                parcel.readString(),
                parcel.readFloat(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                Date(parcel.readLong())
        )

        companion object CREATOR : Parcelable.Creator<Movie> {
                override fun createFromParcel(parcel: Parcel): Movie {
                        return Movie(parcel)
                }

                override fun newArray(size: Int): Array<Movie?> {
                        return arrayOfNulls(size)
                }
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeValue(voteCount?: -1)
                parcel.writeValue(id?: -1)
                parcel.writeValue(video?: false)
                parcel.writeValue(voteAverage?: -1)
                parcel.writeString(title?: "")
                parcel.writeValue(popularity?: -1)
                parcel.writeString(posterPath?: "")
                parcel.writeString(backdropPath?: "")
                parcel.writeString(overview?: "")
                parcel.writeLong(releaseDate?.time?: -1)
        }

        override fun describeContents() = 0
}