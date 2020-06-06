package com.djair.chucknorris.data.source.remote

import com.djair.chucknorris.domain.model.Joke
import retrofit2.http.GET

interface JokeService {
    @GET("jokes/random")
    suspend fun getJokes(): Joke
}