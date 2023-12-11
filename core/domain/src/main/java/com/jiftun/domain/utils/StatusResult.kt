package com.jiftun.domain.utils


sealed interface StatusResult<out R> {
    data object Loading : StatusResult<Nothing>
    data class Success<out T>(val data: T) : StatusResult<T>
    data class Error<out T>(val message: String, val code: Int) : StatusResult<T>
}
