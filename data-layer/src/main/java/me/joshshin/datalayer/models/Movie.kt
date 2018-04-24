package me.joshshin.datalayer.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import me.joshshin.domain.models.FilmedMovie

/**
 * Created by Josh Shin on 4/22/18
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
        override val posterPath: String?,
        @SerializedName("backdrop_path")
        override val backdropPath: String?,
        override val overview: String?,
        @SerializedName("release_date")
        override val releaseDate: String?
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
            parcel.readString()
    )

    companion object CREATOR : Parcelable.Creator<FilmedMovie> {
        override fun createFromParcel(parcel: Parcel): FilmedMovie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<FilmedMovie?> {
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
        parcel.writeString(releaseDate?: "")
    }

    override fun describeContents() = 0
}