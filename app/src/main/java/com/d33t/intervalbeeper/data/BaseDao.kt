package com.d33t.intervalbeeper.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg obj: T)

    @Delete
    fun delete(obj: T)
}
