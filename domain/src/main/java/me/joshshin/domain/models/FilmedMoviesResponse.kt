package me.joshshin.domain.models

/**
 * Created by Josh Shin on 4/22/18
 */

interface FilmedMoviesResponse {
        val page: Int?
        val totalResults: Int?
        val totalPages: Int?
        val results: List<FilmedMovie>?
}