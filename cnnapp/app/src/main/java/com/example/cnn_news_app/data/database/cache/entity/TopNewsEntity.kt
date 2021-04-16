package com.example.cnn_news_app.data.database.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cnn_news_app.model.Article
import com.example.cnn_news_app.model.NewsResponse


@Entity(tableName = "Top_News_Table_cache")
class TopNewsEntity(
    var newsResponse: NewsResponse
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}