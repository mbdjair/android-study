package com.djair.chucknorris.domain.repository

interface JokeRepository {
    suspend fun fetch(): String
}