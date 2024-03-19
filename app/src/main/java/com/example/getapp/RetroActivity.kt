package com.example.getapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.getapp.model.GDATAItem
import com.example.getapp.viewmodel.PostViewModel
import com.example.myretrofitapplication.databinding.ActivityRetroBinding

class RetroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRetroBinding
    private lateinit var postViewModel: PostViewModel
//    private lateinit var getDataAdapter: GetDataAdapter
//    private var ddList = MutableLiveData(emptyList<GDATAItem>())
    private lateinit var dlist:List<GDATAItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRetroBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        postViewModel = ViewModelProvider(this)[PostViewModel::class.java]
        postViewModel.loadEMP()

//        getDataAdapter = GetDataAdapter()
//        binding.getRVIEW.apply {
//            adapter =getDataAdapter
//            layoutManager = LinearLayoutManager(applicationContext)
//        }
        postViewModel.emp.observe(this){
            if (it != null) {
//                getDataAdapter.update(dlist)
//                getDataAdapter.notifyDataSetChanged()
                Log.d("ALll",it.toString())
            }else
            {
                Toast.makeText(applicationContext, "error", Toast.LENGTH_SHORT).show()
            }
        }




    }
}