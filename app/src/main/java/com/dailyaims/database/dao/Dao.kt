package com.dailyaims.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.dailyaims.model.AimsModel

@Dao
interface Dao {
    @Insert(onConflict = IGNORE)
    suspend fun insert(aimsModel: AimsModel)

    @Delete
    suspend fun delet(aimsModel: AimsModel)

    @Query("SELECT*from aims_table")
    fun getAllAims():LiveData<List<AimsModel>>
}