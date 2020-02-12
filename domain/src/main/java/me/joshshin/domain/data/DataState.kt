package me.joshshin.domain.data

/**
 * Created by Josh Shin on 11/11/18
 */

sealed class DataState {
    data class Loading<T>(val cachedValue: T?): DataState()
    data class Success<T>(val data: T): DataState()
    data class Error(val code: Int, val message: String?, val error: Throwable?): DataState()
}

