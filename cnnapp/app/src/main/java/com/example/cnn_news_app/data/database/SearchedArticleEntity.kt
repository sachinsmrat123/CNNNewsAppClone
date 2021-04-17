package com.example.cnn_news_app.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cnn_news_app.data.model.NewsResponse


@Entity(tableName = "SearchedArticlesSaved")
class SearchedArticleEntity(
        var searchedNews:String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}