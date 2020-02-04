package com.d33t.intervalbeeper.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.d33t.intervalbeeper.R
import com.d33t.intervalbeeper.data.Timer
import kotlinx.android.synthetic.main.timer_list_item.view.*

class TimerListAdapter()
    : RecyclerView.Adapter<TimerListAdapter.ViewHolder>() {

    private var timers = emptyList<Timer>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val timerName: TextView = view.timer_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.timer_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.timerName.text = this.timers[position].name
    }

    internal fun setTimers(timers: List<Timer>) {
        this.timers = timers
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = this.timers.size
}
