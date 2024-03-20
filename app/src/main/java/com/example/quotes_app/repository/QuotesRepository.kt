package com.example.quotes_app.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quotes_app.api.QuoteService
import com.example.quotes_app.db.database.QuotesDataBase
import com.example.quotes_app.model.QuotesList

class QuotesRepository(
    private val quoteService: QuoteService,
    private val quotesDataBase: QuotesDataBase
) {

    private val quotesLiveData = MutableLiveData<QuotesList>()

    val quotes : LiveData<QuotesList> get() = quotesLiveData

    suspend fun getQuotes(page :Int){
        val result = quoteService.getQuotes(page)
        if (result.body() != null){
            quotesDataBase.quotesDao().addQuotes(result.body()!!.results)
            quotesLiveData.postValue(result.body())
        }
    }
}