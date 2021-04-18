package com.example.cnn_news_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.cnn_news_app.R
import com.example.cnn_news_app.data.database.SearchedArticleEntity

class SearchedSavedAdapter(private var articles: List<SearchedArticleEntity>,private var listener: SavedSearchedItemClickListener):RecyclerView.Adapter<SearchedSavedAdapter.SearchedNewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchedNewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.saved_serched_item_layout, parent, false)
        return SearchedNewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: SearchedNewsViewHolder, position: Int) {
        holder.mTvSearchSaved.text = articles[position].searchedNews
        holder.mConstraintSaved.setOnClickListener {
            listener.onSearchedItemClicked(articles[position])
        }
    }

    class SearchedNewsViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
       var mConstraintSaved:ConstraintLayout = itemView.findViewById(R.id.constraintSaved)
        var mTvSearchSaved:TextView = itemView.findViewById(R.id.tvSearchSaved)
    }

    fun setData(newData:List<SearchedArticleEntity>){
        articles = newData
        notifyDataSetChanged()
    }
}