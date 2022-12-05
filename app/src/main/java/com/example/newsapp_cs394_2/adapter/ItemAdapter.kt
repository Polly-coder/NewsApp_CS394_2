package com.example.newsapp_cs394_2.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp_cs394_2.*
import com.example.newsapp_cs394_2.model.News
import com.squareup.picasso.Picasso


class ItemAdapter (private val dataset: List <News>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val titleView = view.findViewById<TextView>(R.id.titleView)
        val sourceView = view.findViewById<TextView>(R.id.sourceView)
        val img = view.findViewById<ImageView>(R.id.img_headline)
        lateinit var news: News

        init{
            view.setOnClickListener{
                view.findNavController()
                    .navigate(ListOfNewsFragmentDirections.actionListOfNewsFragmentToNewsDetailsFragment2(news))
            }
        }


        fun bind(news:News){
            this.news =news
            titleView.text = news.title
            sourceView.text = news.source
            Picasso.get().load(R.drawable.not_available).into(img)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val news = dataset[position]
        holder.bind(news)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}