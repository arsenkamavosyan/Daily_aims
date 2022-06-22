package com.dailyaims.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "aims_table")
data class AimsModel(
    @PrimaryKey(autoGenerate = false)
    var id: String,
    var name: String,
    var type:String,
    val dayPLan: String,
    val isReplay: Boolean,
    val isNotification: Boolean
) : Serializable