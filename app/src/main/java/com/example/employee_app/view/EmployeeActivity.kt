package com.example.employee_app.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aarafrao.retrofitmvvm.Adapter.DataAdapter
import com.aarafrao.retrofitmvvm.ViewModel.EmployeeVM
import com.example.myretrofitapplication.R
import com.example.myretrofitapplication.databinding.ActivityEmployeeBinding

class EmployeeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEmployeeBinding
    private lateinit var viewModel: EmployeeVM
    private lateinit var dataAdapter: DataAdapter
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEmployeeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel =ViewModelProvider(this)[EmployeeVM::class.java]
        viewModel.loadEMP()

        dataAdapter = DataAdapter()
        binding.dataRVView.apply {
            adapter = dataAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }

        viewModel.emp.observe(this){ Employee->
            if (Employee != null){
                dataAdapter.updateList(Employee.data)
                dataAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}