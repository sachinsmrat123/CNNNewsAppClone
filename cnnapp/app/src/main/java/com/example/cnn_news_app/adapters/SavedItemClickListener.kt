package com.example.cnn_news_app.adapters

import com.example.cnn_news_app.data.model.Article

interface SavedItemClickListener {
    fun onArticleClicked(article: Article)
    fun onDeleteButtonClicked(article: Article)
    fun onShareButtonClicked(article: Article)
}