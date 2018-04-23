package me.joshshin.filmeddomain.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import org.threeten.bp.LocalDate

/**
 * Created by Josh Shin on 4/22/18
 */
interface FilmedMovie {
        val voteCount: Int?
        val id: Int?
        val video: Boolean?
        val voteAverage: Float?
        val title: String?
        val popularity: Float?
        val posterPath: String?
        val backdropPath: String?
        val overview: String?
        val releaseDate: LocalDate?
}