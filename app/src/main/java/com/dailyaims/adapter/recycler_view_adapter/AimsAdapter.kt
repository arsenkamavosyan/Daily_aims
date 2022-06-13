package com.dailyaims.adapter.recycler_view_adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dailyaims.R
import com.dailyaims.adapter.eventlistener.EventListener
import com.dailyaims.adapter.viewholder.AimsViewHolder
import com.dailyaims.model.AimsModel


class AimsAdapter(private val listener: EventListener) :
    RecyclerView.Adapter<AimsViewHolder>() {

    private var listAims = emptyList<AimsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AimsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.aims_layout, parent, false)
        return AimsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AimsViewHolder, position: Int) {
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