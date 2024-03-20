package com.aarafrao.retrofitmvvm.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employee_app.model.Data
import com.example.myretrofitapplication.databinding.GetRvItemBinding


class DataAdapter() : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
    private var dataList: List<Data>? = null

    fun updateList(dataList: List<Data>?){
        this.dataList = dataList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GetRvItemBinding.inflate(inflater, parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
//        holder.bind(dataList!![position])

        holder.binding.bodytextView.text = "Name: " +dataList!![position].employeeName
        holder.binding.idtextView.text = "AGE: " +dataList!![position].employeeAge.toString()
        holder.binding.titleTextView.text = "Salary: " + dataList!![position].employeeSalary.toString()

    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    class DataViewHolder(var binding: GetRvItemBinding) : RecyclerView.ViewHolder(binding.root)

}

