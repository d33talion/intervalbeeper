package com.d33t.intervalbeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.d33t.intervalbeeper.adapters.TimerListAdapter
import com.d33t.intervalbeeper.viewmodes.TimerListViewModel


class TimersListActivity : AppCompatActivity() {
    private lateinit var viewModel: TimerListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timers_list)

        val viewManager = LinearLayoutManager(this)
        val viewAdapter = TimerListAdapter()

        val recyclerView = findViewById<RecyclerView>(R.id.timers_list).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        this.viewModel = ViewModelProvider(this).get(TimerListViewModel::class.java)
        this.viewModel.timers.observe(this, Observer {timers ->
            timers?.let { viewAdapter.setTimers(it) }
        })
    }
}
