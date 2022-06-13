package com.dailyaims.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "aims_table")
data class AimsModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo
    var title: String = "",
    @ColumnInfo
    val description: String = ""
    ) : Serializable