package com.example.cnn_news_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cnn_news_app.model.Article

class NewsAdapter(private val listener: ItemClickListener):RecyclerView.Adapter<NewsAdapter.NewsViewsHolder>() {

    private var articles = emptyList<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item_layout, parent, false)
        return NewsViewsHolder(view)
    }

    override fun getItemCount(): Int {
       return articles.size
    }

    override fun onBindViewHolder(holder: NewsViewsHolder, position: Int) {
        holder.mTvNews.text = articles[position].title
        Glide.with(holder.mIvNews).load(articles[position].urlToImage).into(holder.mIvNews)

        holder.mIvNews.setOnClickListener {
            listener.onArticleClicked(articles[position])
        }
        var save = articles[position].saved
        holder.mBtnSaveNews.setOnClickListener {
            if (articles[position].saved==0){
                holder.mBtnSaveNews.setImageResource(R.drawable.ic_saved_filled_red)
                listener.onSavedButtonClicked(articles[position])
            }else{
                holder.mBtnSaveNews.setImageResource(R.drawable.ic_saved_outlined_black)
                listener.onSavedButtonClicked(articles[position])
            }
        }

        holder.mBtnShareNews.setOnClickListener {
            listener.onShareButtonClicked(articles[position])
        }
    }

    class NewsViewsHolder(view:View):RecyclerView.ViewHolder(view) {

        val mTvNews: TextView = view.findViewById(R.id.tvNews)
        val mIvNews: ImageView = view.findViewById(R.id.ivNews)
        val mBtnShareNews: ImageView = view.findViewById(R.id.btnShareNews)
        val mBtnSaveNews: ImageView = view.findViewById(R.id.btnSaveNews)

    }

    fun setData(newData: List<Article>){
        val recipesDiffUtil =
            NewsDiffUtil(articles, newData)
        val diffUtilResult = DiffUtil.calculateDiff(recipesDiffUtil)
        articles = newData
        diffUtilResult.dispatchUpdatesTo(this)
    }



}