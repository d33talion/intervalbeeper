package com.d33t.intervalbeeper.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "intervals")
data class Interval(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "timer_id") val timerId: Int,
    val name: String?,
    val duration: Int,
    val order: Int
)
