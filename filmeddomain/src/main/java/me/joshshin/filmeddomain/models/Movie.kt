package me.joshshin.filmeddomain.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import org.threeten.bp.LocalDate

/**
 * Created by Josh Shin on 4/22/18
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
        val posterPath: String?,
        @SerializedName("backdrop_path")
        val backdropPath: String?,
        val overview: String?,
        @SerializedName("release_date")
        val releaseDate: LocalDate?
) : Parcelable {
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
            LocalDate.parse(parcel.readString())
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
        parcel.writeString(releaseDate?.toString()?: "")
    }

    override fun describeContents() = 0
}