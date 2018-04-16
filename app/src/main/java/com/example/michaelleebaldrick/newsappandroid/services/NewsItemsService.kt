package com.example.michaelleebaldrick.newsappandroid.services

import android.os.AsyncTask
import android.util.Log
import com.example.michaelleebaldrick.newsappandroid.activities.newslist.NewsItemData
import com.example.michaelleebaldrick.newsappandroid.dtos.ArticlesResponseDto
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import khttp.get
import java.net.InetAddress

class NewsItemsService() {

    val mapper = jacksonObjectMapper()
   // val writer = mapper.writerWithDefaultPrettyPrinter()
    //val json2 = writer.writeValueAsString(Data2(1, "Baz", "Qux"))
    fun getNewsItems(callback: (items: ArrayList<NewsItemData>) -> Unit) {
       val task = NewsGetItemsAsyncTask(callback)
       task.execute()
    }


    inner class NewsGetItemsAsyncTask: AsyncTask<String, String, ArrayList<NewsItemData>> {
        private val callback: (items: ArrayList<NewsItemData>) ->  Unit

        constructor(callback: (ArrayList<NewsItemData>) -> Unit) {
            this.callback = callback
        }

//        override fun onPreExecute() {
//            super.onPreExecute()
//        }

        override fun doInBackground(vararg strings: String): ArrayList<NewsItemData> {
            val response = mapper.readValue(get("http://10.0.2.2:3003/news/all").text, ArticlesResponseDto::class.java)
            val articles = response.articles.map {
                 NewsItemData(it.author ?: "", it.description, it.publishedAt ?: "", it.title, it.url, it.urlToImage)
            }
            return ArrayList(articles)
        }

        override fun onPostExecute(items: ArrayList<NewsItemData>) {
            super.onPostExecute(items)
            this.callback(items)
        }
    }

}

