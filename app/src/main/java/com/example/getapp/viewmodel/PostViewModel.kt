package com.example.getapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.getapp.model.GDATAItem
import com.example.getapp.repo.GetRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel :ViewModel() {
    private val repo =GetRepo()
    private val _emp = MutableLiveData<GDATAItem>()

    val emp: LiveData<GDATAItem>
        get() = _emp

    fun loadEMP(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = repo.getPosts()
            _emp.postValue(result)
        }
    }

}