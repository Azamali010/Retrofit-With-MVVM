package com.example.quotes_app.model


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "quote")
data class Result(

    @PrimaryKey(autoGenerate = true)
    val quoteId: Int = 0,
    val id: String,
    val author: String,
    val content: String,
    val authorSlug: String,
    val length: Int,
    val dateAdded: String,
    val dateModified: String
)