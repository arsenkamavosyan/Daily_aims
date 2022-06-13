package com.dailyaims.database.repository

import androidx.lifecycle.LiveData
import com.dailyaims.database.dao.Dao
import com.dailyaims.model.AimsModel

class AimsRealization(private val aimsDao: Dao):AimsRepository {
    override val allAims: LiveData<List<AimsModel>>
        get() = aimsDao.getAllAims()

    override suspend fun insertAims(aimsModel: AimsModel, onSuccses: () -> Unit) {
    aimsDao.insert(aimsModel)
        onSuccses ()
    }

    override suspend fun deleteAims(aimsModel: AimsModel, onSuccses: () -> Unit) {
        aimsDao.delet(aimsModel)
        onSuccses()
    }
}