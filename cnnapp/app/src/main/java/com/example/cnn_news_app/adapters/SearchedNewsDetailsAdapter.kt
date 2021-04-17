package com.example.cnn_news_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cnn_news_app.R
import com.example.cnn_news_app.data.model.Article
import com.example.cnn_news_app.util.NewsDiffUtil

class SearchedNewsDetailsAdapter(private var articles: List<Article>, private val listener: SearchedNewsDetailsItemClickListener):RecyclerView.Adapter<SearchedNewsDetailsAdapter.NewsViewsHolderSearchDetails>() {

//    private var articles = emptyList<Article>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewsHolderSearchDetails {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_details_item_layout, parent, false)
        return NewsViewsHolderSearchDetails(view)
    }

    override fun getItemCount(): Int {
       return articles.size
    }


    override fun onBindViewHolder(holder: NewsViewsHolderSearchDetails, position: Int) {
        holder.mTvSearchDetails.text = articles[position].title
        holder.mTvAuthor.text = articles[position].author
        holder.mConstraintSearchDetails.setOnClickListener {
            listener.onSearchedItemClicked(articles[position])
        }
    }

    class NewsViewsHolderSearchDetails(view:View):RecyclerView.ViewHolder(view) {

        val mTvSearchDetails: TextView = view.findViewById(R.id.tvSearchDetails)
        val mTvAuthor: TextView = view.findViewById(R.id.tvAuthor)
        val mConstraintSearchDetails: ConstraintLayout = view.findViewById(R.id.constraintSearchDetails)

    }

    fun setData(newData: List<Article>){
        articles = newData
        notifyDataSetChanged()
//        val recipesDiffUtil = NewsDiffUtil(articles, newData)
//        val diffUtilResult = DiffUtil.calculateDiff(recipesDiffUtil)
//        articles = newData
//        diffUtilResult.dispatchUpdatesTo(this)
    }




}