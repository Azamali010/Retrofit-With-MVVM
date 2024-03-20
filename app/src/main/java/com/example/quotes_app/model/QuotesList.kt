package com.example.quotes_app.model


import androidx.room.Entity
import com.google.gson.annotations.SerializedName



data class QuotesList(
    @SerializedName("count")
    val count: Int,
    @SerializedName("totalCount")
    val totalCount: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("totalPages")
    val totalPages: Int,
    @SerializedName("lastItemIndex")
    val lastItemIndex: Int,
    @SerializedName("results")
    val results: List<Result>
)