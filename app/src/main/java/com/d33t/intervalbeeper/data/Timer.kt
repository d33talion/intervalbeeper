package com.d33t.intervalbeeper.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "timers")
data class Timer(val name: String) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
