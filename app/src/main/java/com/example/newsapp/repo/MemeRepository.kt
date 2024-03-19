package com.example.newsapp.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.api.ApiInterface
import com.example.newsapp.model.Jokes

class MemeRepository(private val apiInterface: ApiInterface) {
    private val memesLiveData = MutableLiveData<Jokes>()
    val memes : LiveData<Jokes>
        get() = memesLiveData
    suspend fun getsMemes(){
        val result = apiInterface.getJokes()

        if (result.body() != null){
            memesLiveData.postValue(result.body())
        }
    }

}