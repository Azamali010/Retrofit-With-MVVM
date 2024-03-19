package com.example.getapp.utils

import com.example.getapp.model.GDATAItem
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    suspend fun getPost() : GDATAItem
}