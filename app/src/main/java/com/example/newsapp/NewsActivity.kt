package com.example.newsapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myretrofitapplication.R
import com.example.myretrofitapplication.databinding.ActivityNewsBinding
import com.example.newsapp.adapter.MemesAdapter
import com.example.newsapp.api.ApiInterface
import com.example.newsapp.api.ApiUtilites
import com.example.newsapp.model.Meme
import com.example.newsapp.repo.MemeRepository
import com.example.newsapp.viewmodel.MemesViewModel
import com.example.newsapp.viewmodelfectory.MemesViewModelFactory

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding

    private lateinit var memesViewModel: MemesViewModel

    private lateinit var memesAdapter: MemesAdapter

    private lateinit var dList :List<Meme>

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNewsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        dList = listOf()

        memesAdapter = MemesAdapter(dList)

        val apiInterface = ApiUtilites.getInstance().create(ApiInterface::class.java)
        val memeRepo = MemeRepository(apiInterface)
        memesViewModel = ViewModelProvider(this,MemesViewModelFactory(memeRepo)).get(MemesViewModel::class.java)

        memesViewModel.memes

        binding.MemesRView.apply {
            adapter = memesAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }
        memesViewModel.memes.observe(this) {
            if (it != null) {
                memesAdapter.update(dList)
                memesAdapter.notifyDataSetChanged()
                Log.d("ALL","${it.data.memes}")
            } else {
                Toast.makeText(this, "Ali", Toast.LENGTH_SHORT).show()
            }


        }


//        memesViewModel.memes.observe(this) { joke->
//
////            binding.nameTextView.text = joke.toString()
////            it.data.memes.iterator().forEach {
////
////                Log.d("Ali", "Azam : ${it.toString()}")
////            }
//
//        }

//        binding.MemesRView.apply {
//            memesAdapter = MemesAdapter(dList)
//            adapter = memesAdapter
//            layoutManager = LinearLayoutManager(this@NewsActivity)
//        }

//        reAdapter()
//        rViewModel()
//        memesViewModel.memes.observe(this){ joke->
//            if (joke != null){
//                memesAdapter = MemesAdapter()
//                memesAdapter.notifyDataSetChanged()
//                binding.MemesRView.adapter = memesAdapter
//            }
////         binding.MemesRView.also {
////             it.layoutManager = LinearLayoutManager(this)
////             it.adapter = MemesAdapter(dList)
////         }
//        }

    }

//    private fun rViewModel() {
//        memesViewModel.memes.observe(this) {
//            if (it != null) {
//                memesAdapter.update(dList)
//            }else{
//                Toast.makeText(this, "hiiii", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//    }
//
//    private fun reAdapter() {
//        binding.MemesRView.layoutManager  =LinearLayoutManager(this)
//        memesAdapter = MemesAdapter(dList)
//        binding.MemesRView.adapter = memesAdapter
//    }
}