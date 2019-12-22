package com.d33t.intervalbeeper.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Calendar

@Entity(tableName = "timers")
data class Timer(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    val name: String,
    @ColumnInfo(name = "creation_date") val creationDate: Calendar = Calendar.getInstance()
)
