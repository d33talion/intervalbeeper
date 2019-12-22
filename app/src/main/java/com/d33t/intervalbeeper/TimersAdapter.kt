package com.d33t.intervalbeeper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.timer_list_item.view.*

class TimersAdapter(private val myDataset: Array<String>)
    : RecyclerView.Adapter<TimersAdapter.TimersViewHolder>() {

    class TimersViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val timerName = view.timer_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimersViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.timer_list_item, parent, false)

        return TimersViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimersViewHolder, position: Int) {
        holder.timerName.text = myDataset[position]
    }

    override fun getItemCount(): Int = myDataset.size
}
