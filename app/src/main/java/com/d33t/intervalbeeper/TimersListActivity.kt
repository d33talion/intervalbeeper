package com.d33t.intervalbeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class TimersListActivity : AppCompatActivity() {
    private lateinit var recylerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timers_list)

        // TEST //
        val myDataset = arrayOf("timer1", "timer2", "timer3", "timer1", "timer2", "timer3", "timer1", "timer2", "timer3", "timer1", "timer2", "timer3", "timer1", "timer2", "timer3")
        // TEST //

        this.viewManager = LinearLayoutManager(this)
        this.viewAdapter = TimersAdapter(myDataset)

        this.recylerView = findViewById<RecyclerView>(R.id.timers_list).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
