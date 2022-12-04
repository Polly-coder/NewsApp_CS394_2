package com.example.newsapp_cs394_2.data

import android.content.Context
import com.example.newsapp_cs394_2.R
import com.example.newsapp_cs394_2.model.News


class DataSourse (val context: Context) {
    fun getTital(): Array<String> {
        return context.resources.getStringArray(R.array.title_array)
    }
    fun getDescription(): Array<String> {
        return context.resources.getStringArray(R.array.description_array)
    }


    fun loadNews(): List<News>{
        val titalList = getTital()
        val descriptionlList = getDescription()
        var news = mutableListOf<News>()

        for (i in 0..9){
            val country = News(titalList[i], descriptionlList[i])
            news.add(country)
        }
        return news
    }
}