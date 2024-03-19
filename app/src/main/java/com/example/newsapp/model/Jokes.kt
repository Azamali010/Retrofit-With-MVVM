package com.example.newsapp.model


import com.google.gson.annotations.SerializedName

data class Jokes(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("data")
    val `data`: Data
)