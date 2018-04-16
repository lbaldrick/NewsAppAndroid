package com.example.michaelleebaldrick.newsappandroid.activities.newslist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.michaelleebaldrick.newsappandroid.R
import com.example.michaelleebaldrick.newsappandroid.services.NewsItemsService
import kotlinx.android.synthetic.main.activity_news_list.*

class NewsListActivity : AppCompatActivity() {

    private val newsItems: ArrayList<NewsItemData> = ArrayList()
    private val service: NewsItemsService = NewsItemsService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
        rv_news_item_list.layoutManager = LinearLayoutManager(this)
        rv_news_item_list.adapter = NewsItemAdapter(newsItems, this)

        service.getNewsItems({ items: ArrayList<NewsItemData> ->
            rv_news_item_list.adapter = NewsItemAdapter(items, this)
        })

    }
}
