package com.d33t.intervalbeeper.viewmodes

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d33t.intervalbeeper.data.Timer
import com.d33t.intervalbeeper.data.TimerRepository

class TimerListViewModel(timerRepository: TimerRepository) : AndroidViewModel() {
    val timers: LiveData<List<Timer>> = timerRepository.timers

    fun addTimer(name: String) {
        viewModelScope.launch
    }
}
