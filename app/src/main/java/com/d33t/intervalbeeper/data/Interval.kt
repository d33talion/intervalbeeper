package com.d33t.intervalbeeper.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "intervals",
    foreignKeys = [
        ForeignKey(
            entity = Timer::class,
            parentColumns = ["id"],
            childColumns = ["timer_id"],
            onDelete = ForeignKey.CASCADE)])
data class Interval(
    @ColumnInfo(name = "timer_id") val timerId: Int,
    val name: String?,
    val durationSeconds: Int,
    val order: Int
) {
    @PrimaryKey(autoGenerate = true) val id: Int = 0
}
