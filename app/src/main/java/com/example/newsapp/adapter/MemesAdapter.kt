package com.example.newsapp.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofitapplication.databinding.RvItemBinding
import com.example.newsapp.model.Meme

class MemesAdapter(private var mList :List<Meme>
):RecyclerView.Adapter<MemesAdapter.MemesViewHolder>() {


    inner class MemesViewHolder( var binding: RvItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemesViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MemesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(list: List<Meme>?) {
        mList = list.orEmpty()
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: MemesViewHolder, position: Int) {
        holder.binding.idTextView.text = mList[position].id
        holder.binding.AAnameTextView.text = mList[position].name


    }
}