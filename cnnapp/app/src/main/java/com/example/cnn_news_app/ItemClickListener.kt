package com.example.cnn_news_app

import com.example.cnn_news_app.model.Article

interface ItemClickListener {
    fun onArticleClicked(article: Article)
    fun onSavedButtonClicked(article: Article)
    fun onShareButtonClicked(article: Article)
}