package com.example.newsapp.viewmodelfectory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.repo.MemeRepository
import com.example.newsapp.viewmodel.MemesViewModel


class MemesViewModelFactory(private val memeRepository: MemeRepository) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MemesViewModel(memeRepository) as T
    }
}