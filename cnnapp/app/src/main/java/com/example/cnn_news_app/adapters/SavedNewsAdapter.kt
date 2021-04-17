package com.example.cnn_news_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cnn_news_app.util.NewsDiffUtil
import com.example.cnn_news_app.R
import com.example.cnn_news_app.data.model.Article

class SavedNewsAdapter(private var articles: List<Article>, private val listener: SavedItemClickListener):RecyclerView.Adapter<SavedNewsAdapter.NewsViewsHolder>() {

//    private var articles = emptyList<Article>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.saved_news_item_layout, parent, false)
        return NewsViewsHolder(view)
    }

    override fun getItemCount(): Int {
       return articles.size
    }

    override fun onBindViewHolder(holder: NewsViewsHolder, position: Int) {
        holder.mSavedNewsHeading.text = articles[position].title
        Glide.with(holder.mSavedNewsImage).load(articles[position].urlToImage).into(holder.mSavedNewsImage)

        holder.mSavedCard.setOnClickListener {
            listener.onArticleClicked(articles[position])
        }

        holder.mBtnDeleteSavedNews.setOnClickListener {
            listener.onDeleteButtonClicked(articles[position])
        }

        holder.mBtnShareSavedNews.setOnClickListener {
            listener.onShareButtonClicked(articles[position])
        }
    }

    class NewsViewsHolder(view:View):RecyclerView.ViewHolder(view) {

        val mSavedCard:CardView =  view.findViewById(R.id.savedCard)
        val mSavedNewsHeading: TextView = view.findViewById(R.id.savedHading)
        val mSavedNewsImage: ImageView = view.findViewById(R.id.imageSaved)
        val mBtnShareSavedNews: ImageView = view.findViewById(R.id.btnShareSavedNews)
        val mBtnDeleteSavedNews: ImageView = view.findViewById(R.id.btnDeleteSavedNews)

    }

    fun setData(newData: List<Article>){
//        articles = newData
//        notifyDataSetChanged()

        val recipesDiffUtil = NewsDiffUtil(articles, newData)
        val diffUtilResult = DiffUtil.calculateDiff(recipesDiffUtil)
        articles = newData
        diffUtilResult.dispatchUpdatesTo(this)
    }



}