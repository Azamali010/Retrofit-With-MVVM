package com.example.myretrofitapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.employee_app.view.EmployeeActivity
import com.example.getapp.RetroActivity
import com.example.myretrofitapplication.databinding.ActivityMainBinding
import com.example.newsapp.NewsActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        countryName()
    }

    private fun countryName() {
        binding.CountryImageView.setOnClickListener {
            val intent = Intent(this,EmployeeActivity::class.java)
            startActivity(intent)
        }
    }
}