package com.example.quotes_app.application

import android.app.Application
import com.example.quotes_app.api.QuoteService
import com.example.quotes_app.db.database.QuotesDataBase
import com.example.quotes_app.repository.QuotesRepository
import com.example.quotes_app.retrofit.RetrofitHelper

class QuoteApplication:Application() {

    lateinit var quotesRepository: QuotesRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuotesDataBase.getDatabase(applicationContext)
        quotesRepository = QuotesRepository(quoteService,database)
    }
}