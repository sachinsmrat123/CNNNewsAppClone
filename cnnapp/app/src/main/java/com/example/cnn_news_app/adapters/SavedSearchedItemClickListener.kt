package com.example.cnn_news_app.adapters

import com.example.cnn_news_app.data.database.SearchedArticleEntity
import com.example.cnn_news_app.data.model.Article

interface SavedSearchedItemClickListener {
    fun onSearchedItemClicked(searchedArticleEntity: SearchedArticleEntity)
}