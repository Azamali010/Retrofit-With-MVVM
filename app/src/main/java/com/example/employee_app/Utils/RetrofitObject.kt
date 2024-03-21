package com.aarafrao.retrofitmvvm.Utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {

    private const val BASE_URL = "https://dummy.restapiexample.com/"
    private const val BASE_URL2 = "https://api.imgflip.com/"

//    val apiService: ApiService = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        .create(ApiService::class.java)

    val apiService :ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

//    val apiService2 :ApiService by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL2)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiService::class.java)
//    }
}