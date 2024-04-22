package com.example.postapp.api

import com.example.postapp.model.PostData
import retrofit2.Response
import retrofit2.http.GET

interface PostService {

    @GET("/posts")
    suspend fun getPost() :Response<PostData>
}