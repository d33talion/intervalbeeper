package com.d33t.intervalbeeper.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "timers")
data class Timer(
    @PrimaryKey val id: Int,
    val name: String
)
