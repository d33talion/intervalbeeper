package com.d33t.intervalbeeper.data

class IntervalRepository private constructor(
    private val intervalDao: IntervalDao
){
    fun getIntervalsForTimer(timer: Timer) = intervalDao.getIntervalsForTimer(timer.id)

    suspend fun addInterval(duration: Int, order: Int, timer: Timer)
            = doAddInterval(null, duration, order, timer)

    suspend fun addInterval(name: String, duration: Int, order: Int, timer: Timer)
            = doAddInterval(name, duration, order, timer)

    suspend fun deleteInterval(interval: Interval) = intervalDao.delete(interval)

    private fun doAddInterval(name: String?, duration: Int, order: Int, timer: Timer) {
        val interval = Interval(timer.id, name, duration, order)
        intervalDao.insert(interval)
    }

    companion object {
        @Volatile private var instance: IntervalRepository? = null

        fun getInstance(intervalDao: IntervalDao) =
            instance ?: synchronized(this) {
                instance ?: IntervalRepository(intervalDao).also { instance = it }
            }
    }
}
