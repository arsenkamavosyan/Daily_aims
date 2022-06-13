package com.dailyaims.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dailyaims.database.dao.Dao
import com.dailyaims.model.AimsModel

@Database(entities = [AimsModel::class], version = 1)
abstract class AimsDataBase : RoomDatabase() {

    abstract fun getAimsDao(): Dao

    companion object {
        private var database: AimsDataBase? = null
        @Synchronized
        fun getInstanse(context: Context): AimsDataBase {
            return if (database == null) {

                database = Room.databaseBuilder(context, AimsDataBase::class.java, "db")
                    .build()
                database as AimsDataBase
            } else {
                database as AimsDataBase
            }
        }
    }
}