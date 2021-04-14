package com.example.cnn_news_app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cnn_news_app.model.Article


@Database(
    entities = [Article::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(NewsTypeConverter::class)
abstract class NewsDatabase: RoomDatabase() {

    abstract fun articleDao():ArticleDao

}