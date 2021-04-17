package com.example.cnn_news_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cnn_news_app.R
import com.example.cnn_news_app.data.database.SearchedArticleEntity
import com.example.cnn_news_app.data.model.Article

class SavedSearchedAdapter(private var articles: List<SearchedArticleEntity>, private val listener: SavedSearchedItemClickListener):RecyclerView.Adapter<SavedSearchedAdapter.NewsViewsHolder>() {

//    private var articles = emptyList<Article>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.saved_news_item_layout, parent, false)
        return NewsViewsHolder(view)
    }

    override fun getItemCount(): Int {
       return articles.size
    }

    override fun onBindViewHolder(holder: NewsViewsHolder, position: Int) {
        holder.mTvTitle.text = articles[position].searchedNews


        holder.mSavedConstraint.setOnClickListener {
            listener.onSearchedItemClicked(articles[position])
        }
    }

    class NewsViewsHolder(view:View):RecyclerView.ViewHolder(view) {

        val mTvTitle: TextView = view.findViewById(R.id.tvSearchSaved)
        val mSavedConstraint:ConstraintLayout  = view.findViewById(R.id.constraintSaved)

    }

    fun setData(newData: List<SearchedArticleEntity>){
        articles = newData
        notifyDataSetChanged()

//        val recipesDiffUtil = NewsDiffUtil(articles, newData)
//        val diffUtilResult = DiffUtil.calculateDiff(recipesDiffUtil)
//        articles = newData
//        diffUtilResult.dispatchUpdatesTo(this)
    }



}