//package com.example.getapp.adapter
//
//
//
//
//import android.annotation.SuppressLint
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.getapp.model.GDATAItem
//import com.example.myretrofitapplication.databinding.GetRvItemBinding
//
//
//class GetDataAdapter():RecyclerView.Adapter<GetDataAdapter.GetViewHolder>() {
//
//    private var mList :List<GDATAItem>? = null
//
//
//     class GetViewHolder(
//         private var binding: GetRvItemBinding
//     ):RecyclerView.ViewHolder(binding.root){
//        fun bind(gdataItem: GDATAItem) {
//            binding.apply {
//                // Bind the data to the views
////                nameTextView.text = data.employee_name
////                ageTextView.text = "Age: "+data.employee_age.toString()
////                salaryTextView.text = "Salary: "+data.employee_salary.toString()
//              idtextView.text = gdataItem.id.toString()
//                titleTextView.text = gdataItem.title
//                bodytextView.text = gdataItem.body
//
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GetViewHolder {
//        val binding = GetRvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return GetViewHolder(binding)
//    }
//
//    override fun getItemCount(): Int {
//         return mList?.size ?: 0
//    }
//
//    @SuppressLint("NotifyDataSetChanged")
//    fun update(list: List<GDATAItem>?) {
//        mList = list.orEmpty()
//        notifyDataSetChanged()
//
//    }
//
//    override fun onBindViewHolder(holder: GetViewHolder, position: Int) {
//        holder.bind(mList!![position])
//
//    }
//}