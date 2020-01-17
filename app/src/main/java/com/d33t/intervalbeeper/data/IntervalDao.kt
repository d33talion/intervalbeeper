package com.d33t.intervalbeeper.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
abstract class IntervalDao : BaseDao<Interval> {
    @Query("SELECT * FROM [intervals] WHERE [timer_id] = :timerId ORDER BY [order] ASC")
    abstract fun getIntervalsForTimer(timerId: Int): LiveData<List<Interval>>

    @Query("DELETE FROM intervals WHERE [timer_id] = :timerId")
    abstract fun deleteAllIntervalsForTimer(timerId: Int)
}
