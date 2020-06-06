package com.djair.chucknorris.data.repository

import com.djair.chucknorris.data.source.remote.JokeService
import com.djair.chucknorris.domain.repository.JokeRepository

class JokeRepositoryImpl(private val service: JokeService) :
    JokeRepository {
    override suspend fun fetch(): String {
        return service.getJokes().value
    }
}