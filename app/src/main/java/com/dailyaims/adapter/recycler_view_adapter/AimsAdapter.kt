package com.dailyaims.adapter.recycler_view_adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dailyaims.model.AimsModel
import com.dailyaims.R
import com.dailyaims.databinding.AimsLayoutBinding
import kotlinx.android.synthetic.main.aims_layout.view.*


class AimsAdapter(private val listener: EventListener) :
    RecyclerView.Adapter<AimsAdapter.ViewHolder>() {

    var listAims = emptyList<AimsModel>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = AimsLayoutBinding.bind(itemView)
        fun bind(aims: AimsModel) = with(binding) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.aims_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listAims[position])
        holder.itemView.tv_title.text = listAims[position].title.toString()
        holder.itemView.setOnClickListener {
            listener.onItemClicked(listAims[position])
        }
    }

    override fun getItemCount(): Int {
        return listAims.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<AimsModel>) {
        listAims = list
        notifyDataSetChanged()
    }

    interface EventListener {
        fun onItemClicked(aims: AimsModel)
    }
}