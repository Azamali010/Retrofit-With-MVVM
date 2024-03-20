package com.example.quotes_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.myretrofitapplication.R
import com.example.myretrofitapplication.databinding.ActivityQuotesBinding
import com.example.quotes_app.api.QuoteService
import com.example.quotes_app.viewmodel.MainViewModelFactory
import com.example.quotes_app.viewmodel.QuotesViewModel
import com.example.quotes_app.repository.QuotesRepository
import com.example.quotes_app.retrofit.RetrofitHelper
import retrofit2.create

class QuotesActivity : AppCompatActivity() {
    private lateinit var quotesViewModel: QuotesViewModel
    private lateinit var binding: ActivityQuotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository = QuotesRepository(quoteService)
        quotesViewModel = ViewModelProvider(this,
            MainViewModelFactory(repository)
        )[QuotesViewModel::class.java]

        quotesViewModel.quotes.observe(this){
            Log.d("ALL", it.results.toString())
        }
    }
}