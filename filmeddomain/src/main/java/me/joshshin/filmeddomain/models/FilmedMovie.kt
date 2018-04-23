package me.joshshin.filmeddomain.models

import java.util.*

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
    val releaseDate: Date?
}