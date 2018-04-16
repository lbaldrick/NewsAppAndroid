package com.example.michaelleebaldrick.newsappandroid.activities.newslist


import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.example.michaelleebaldrick.newsappandroid.R
import kotlinx.android.synthetic.main.news_item_row.view.*

class NewsItemAdapter(val items : ArrayList<NewsItemData>, val context: Context) : RecyclerView.Adapter<NewsItemHolder>() {

    //Inflates the items view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemHolder {
        return NewsItemHolder(LayoutInflater.from(context).inflate(R.layout.news_item_row, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    //Binds each item data to view
    override fun onBindViewHolder(holder: NewsItemHolder, position: Int) {
        val item = items[position]
        holder.bindItem(item)

        if (position % 2 == 0) {

            holder.itemView.setBackgroundColor(Color.parseColor("#B9E2EE"))

        } else {

            holder.itemView.setBackgroundColor(Color.parseColor("#E4EAEC"))

        }
    }

}

class NewsItemHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

    private lateinit var itemData: NewsItemData
    private var view: View = view

    init {
        view.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        Log.d("RecyclerView","Item Clicked")
    }

    fun bindItem(itemData: NewsItemData) {
        this.itemData = itemData
        view.authorLbl.text = itemData.author.trim()
        view.descriptionLbl.text = itemData.description
        view.publishedAtLbl.text = itemData.publishedAt
        view.titleLbl.text = itemData.title
    }

    companion object {
        private val NEWS_ITEM_KEY = "NEWS_ITEM"
    }
}