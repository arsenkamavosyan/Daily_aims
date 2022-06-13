package com.dailyaims.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dailyaims.adapter.eventlistener.EventListener
import com.dailyaims.databinding.AimsLayoutBinding
import com.dailyaims.model.AimsModel
import kotlinx.android.synthetic.main.aims_layout.view.*

class AimsViewHolder(itemView: View) : ViewHolder(itemView) {

    private val binding = AimsLayoutBinding.bind(itemView)
    fun bind(aims: AimsModel, listener: EventListener) = with(binding) {
        itemView.tv_title.text = aims.title.toString()
        itemView.setOnClickListener {
            listener.onItemClicked(aims)
        }
    }
}