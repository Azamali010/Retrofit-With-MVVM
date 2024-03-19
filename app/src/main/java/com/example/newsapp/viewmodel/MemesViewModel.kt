package com.example.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.model.Jokes
import com.example.newsapp.repo.MemeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemesViewModel(private val memeRepository: MemeRepository):ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            memeRepository.getsMemes()
        }
    }

    val memes :LiveData<Jokes>
        get () = memeRepository.memes
}