package com.dailyaims.adapter.recycler_view_adapter

import com.dailyaims.model.AimsModel

interface EventListener {
    fun onItemClicked(aims: AimsModel)
}