package com.example.stacktask.ViewPager2

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.stacktask.R
import com.example.stacktask.models.Task
import com.example.stacktask.ViewPager2.CardColor

class TaskPagerAdapter(val tasks : List<Task>) : RecyclerView.Adapter<TaskPagerAdapter.ViewHolder>() {

    var colorPicker = 1





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_pager_element, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //TODO Just making a note if you change anything relating to these val/vars or what is referenced here
        // you will need to clear data or crash repeatedly
        holder.text.text = tasks.get(tasks.size-position-1).name
        var color: String = tasks.get(tasks.size-position-1).color
        holder.cardView.setCardBackgroundColor(Color.parseColor(color))
        var i = 1
        holder.cardView.setOnClickListener {
            //color += 500
            color = tasks.get(i%tasks.size).color
            it.setBackgroundColor(Color.parseColor(color))
            ++i
        }


    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.tf_textview)
        val cardView: CardView = itemView.findViewById(R.id.card_view_parent)

    }
}