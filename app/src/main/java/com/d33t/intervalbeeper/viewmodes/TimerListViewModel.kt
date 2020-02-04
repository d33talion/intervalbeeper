package com.d33t.intervalbeeper.viewmodes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.d33t.intervalbeeper.data.AppDatabase
import com.d33t.intervalbeeper.data.Timer
import com.d33t.intervalbeeper.data.TimerRepository
import kotlinx.coroutines.launch

class TimerListViewModel(application: Application) : AndroidViewModel(application) {

    private val timerRepository: TimerRepository

    val timers: LiveData<List<Timer>>

    init {
        val timerDao = AppDatabase.getInstance(application).timerDao()
        this.timerRepository = TimerRepository.getInstance(timerDao)
        this.timers = timerRepository.timers
    }

    fun addTimer(name: String) =
        viewModelScope.launch {
            timerRepository.addTimer(name)
        }

    fun removeTimer(timer: Timer) {
        viewModelScope.launch {
            timerRepository.deleteTimer(timer)
        }
    }
}
