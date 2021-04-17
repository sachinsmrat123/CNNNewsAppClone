package com.example.cnn_news_app.data.database.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cnn_news_app.data.model.NewsResponse


@Entity(tableName = "Sports_News_Table_cache")
class SportsNewsEntity(
    var newsResponse: NewsResponse
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}