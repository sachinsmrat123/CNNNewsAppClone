package com.example.cnn_news_app.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "SearchedArticlesSaved",indices = [Index(value = ["title"], unique = true)])
class SearchedArticleEntity(
    @ColumnInfo(name = "title") var searchedNews:String
) {
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id") var id: Int? = null
}