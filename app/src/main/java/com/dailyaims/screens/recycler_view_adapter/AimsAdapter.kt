package com.dailyaims.screens.recycler_view_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dailyaims.Aims
import com.dailyaims.R
import com.dailyaims.databinding.CardBinding


class AimsAdapter : RecyclerView.Adapter<AimsAdapter.ViewHolder>() {
    val aimsList = ArrayList<Aims>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = CardBinding.bind(itemView)

        fun bind(aims: Aims) = with(binding) {
            tvTitle.text = aims.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(aimsList[position])
    }

    override fun getItemCount(): Int {
        return aimsList.size
    }

    fun addAims(aims: Aims) {
        aimsList.add(aims)
        notifyDataSetChanged()
    }
}