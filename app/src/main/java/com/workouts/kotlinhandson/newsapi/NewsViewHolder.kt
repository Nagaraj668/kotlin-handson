package com.workouts.kotlinhandson.newsapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.workouts.kotlinhandson.R

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(news: News?) {
        if (news != null) {
            itemView.findViewById<TextView>(R.id.txt_news_name).text = news.login
            Picasso.get().load(news.image).into(itemView.findViewById<ImageView>(R.id.img_news_banner))
        }
    }

    companion object {
        fun create(parent: ViewGroup): NewsViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_news, parent, false)
            return NewsViewHolder(view)
        }
    }
}