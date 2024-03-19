package com.example.getapp.repo

import com.example.getapp.model.GDATAItem
import com.example.getapp.utils.RetrofitObject

class GetRepo {

    private val apiService = RetrofitObject.apiService

    suspend fun getPosts(): GDATAItem {
        return apiService.getPost()
    }
}