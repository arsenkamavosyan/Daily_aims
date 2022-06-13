package com.dailyaims.database.repository

import androidx.lifecycle.LiveData
import com.dailyaims.model.AimsModel

interface AimsRepository {
    val allAims: LiveData<List<AimsModel>>
    suspend fun insertAims(aimsModel: AimsModel, onSuccses: () -> Unit)
    suspend fun deleteAims(aimsModel: AimsModel, onSuccses: () -> Unit)
}