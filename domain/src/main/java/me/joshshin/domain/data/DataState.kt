package me.joshshin.domain.data

/**
 * Created by Josh Shin on 11/11/18
 */

data class DataState<D>(
        val state: State,
        val data: D? = null
) {
    sealed class State {
        object Loading: State()
        object Success: State()
        data class Error(val code: Int): State()
    }
}

