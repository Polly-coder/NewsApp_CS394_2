package com.example.newsapp_cs394_2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp_cs394_2.R
import com.example.newsapp_cs394_2.model.News


class ItemAdapter (private val dataset: List <News>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val titleView = view.findViewById<TextView>(R.id.titleView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(layout )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val news = dataset[position]
        holder.titleView.text = news.title
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}