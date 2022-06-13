package com.dailyaims.adapter.eventlistener

import com.dailyaims.model.AimsModel

interface EventListener {
    fun onItemClicked(aims: AimsModel)
}