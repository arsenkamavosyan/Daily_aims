package com.dailyaims.adapter.recycler_view_adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dailyaims.R
import com.dailyaims.model.AimsModel


class AimsAdapter(private val listener: EventListener) :
    RecyclerView.Adapter<MyViewHolder>() {

    private var listAims = emptyList<AimsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.aims_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listAims[position], listener)
    }

    override fun getItemCount(): Int {
        return listAims.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<AimsModel>) {
        listAims = list
        notifyDataSetChanged()
    }
}