package com.d33t.intervalbeeper.viewmodes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d33t.intervalbeeper.data.Timer
import com.d33t.intervalbeeper.data.TimerRepository
import kotlinx.coroutines.launch

class TimerListViewModel(val timerRepository: TimerRepository) : ViewModel() {
    val timers: LiveData<List<Timer>> = timerRepository.timers

    fun addTimer(name: String) {
        viewModelScope.launch {
            timerRepository.addTimer(name)
        }
    }

    fun removeTimer(timer: Timer) {
        viewModelScope.launch {
            timerRepository.deleteTimer(timer)
        }
    }
}
