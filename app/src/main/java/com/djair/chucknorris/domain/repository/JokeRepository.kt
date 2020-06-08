package com.djair.chucknorris.domain.repository

import com.djair.chucknorris.domain.config.Result

interface JokeRepository {
    suspend fun fetch(): Result<String>
}