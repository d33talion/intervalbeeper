package com.d33t.intervalbeeper.data

import androidx.lifecycle.LiveData

class TimerRepository private constructor(
    private val timerDao: TimerDao
){
    val timers: LiveData<List<Timer>> = timerDao.getTimers()

    suspend fun addTimer(name: String) {
        val timer = Timer(name)
        timerDao.insert(timer)
    }

    suspend fun deleteTimer(timer: Timer) = timerDao.delete(timer)

    companion object {
        @Volatile private var instance: TimerRepository? = null

        fun getInstance(timerDao: TimerDao) =
            instance ?: synchronized(this) {
                instance ?: TimerRepository(timerDao).also { instance = it }
            }
    }
}
