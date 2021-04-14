package com.example.cnn_news_app.Models


import com.google.gson.annotations.SerializedName

data class NewsModel(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)