package com.workouts.kotlinhandson.newsapi

import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.workouts.kotlinhandson.R

class ListFooterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(status: State?) {
        itemView.findViewById<ProgressBar>(R.id.progress_bar).visibility =
            if (status == State.LOADING) VISIBLE else View.INVISIBLE
        itemView.findViewById<TextView>(R.id.txt_error).visibility =
            if (status == State.ERROR) VISIBLE else View.INVISIBLE
    }

    companion object {
        fun create(retry: () -> Unit, parent: ViewGroup): ListFooterViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_footer, parent, false)
            view.findViewById<TextView>(R.id.txt_error).setOnClickListener { retry() }
            return ListFooterViewHolder(view)
        }
    }
}