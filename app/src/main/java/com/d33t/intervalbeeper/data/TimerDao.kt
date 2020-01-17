package com.d33t.intervalbeeper.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
abstract class TimerDao : BaseDao<Timer> {
    @Query("SELECT * FROM timers ORDER BY id ASC")
    abstract fun getTimers() : LiveData<List<Timer>>
}
