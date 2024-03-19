package com.example.newsapp.api

import com.example.newsapp.model.Jokes
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("get_memes")
    suspend fun getJokes():Response<Jokes>
}