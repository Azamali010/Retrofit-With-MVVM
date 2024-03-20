package com.example.quotes_app.api

import com.example.quotes_app.model.QuotesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page")page:Int) : Response<QuotesList>
}