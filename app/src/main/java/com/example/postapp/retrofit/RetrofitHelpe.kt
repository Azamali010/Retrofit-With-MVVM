package com.example.postapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelpe {
    const val BASR_URL = "https://jsonplaceholder.typicode.com/"

    fun getPostInstance(): Retrofit{
        return  Retrofit.Builder()
            .baseUrl(BASR_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}