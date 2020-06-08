package com.djair.chucknorris.data.repository

import com.djair.chucknorris.data.source.remote.JokeService
import com.djair.chucknorris.domain.config.Result
import com.djair.chucknorris.domain.repository.JokeRepository
import java.net.UnknownHostException

class JokeRepositoryImpl(private val service: JokeService) :
    JokeRepository {
    override suspend fun fetch(): Result<String> {
        return try {
            Result.Success(service.getJokes().value)
        } catch (error: Throwable) {
            if (error is UnknownHostException)
                return Result.Error(Error("Ops no more jokes to you. Verify your internet connection."))
            Result.Error(error)
        }
    }
}