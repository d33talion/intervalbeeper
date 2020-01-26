package com.d33t.intervalbeeper.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.d33t.intervalbeeper.R
import kotlinx.android.synthetic.main.timer_list_item.view.*

class TimerListAdapter(private val myDataset: Array<String>)
    : RecyclerView.Adapter<TimerListAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val timerName = view.timer_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.timer_list_item, parent, false)

        return ViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.timerName.text = myDataset[position]
    }

    override fun getItemCount(): Int = myDataset.size
}
