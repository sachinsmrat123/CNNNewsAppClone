package com.example.cnn_news_app.adapters

import com.example.cnn_news_app.data.model.Article

interface ItemClickListener {
    fun onArticleClicked(article: Article)
    fun onSavedButtonClicked(article: Article)
    fun onShareButtonClicked(article: Article)
}