package com.example.quotes_app.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.quotes_app.model.Result
@Dao
interface QuotesDao {

    @Insert
    suspend fun addQuotes(quotes: List<Result>)

    @Query("SELECT * FROM quote")
    suspend fun getQuotes():List<Result>
}