package com.djair.chucknorris.domain.config

sealed class Result<out T: Any> {
    data class Success<out T: Any>(val data: T): Result<T>()
    data class Error<T: Throwable>(val error: T): Result<Nothing>()
}