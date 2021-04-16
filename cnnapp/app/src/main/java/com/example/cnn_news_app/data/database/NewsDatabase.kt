package com.example.cnn_news_app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cnn_news_app.data.database.cache.entity.*
import com.example.cnn_news_app.model.Article


@Database(
    entities = [Article::class,TopNewsEntity::class],
    version = 1,
    exportSchema = false

//    ,BusinessNewsEntity::class,
//    EntertainmentNewsEntity::class,HealthNewsEntity::class,SportsNewsEntity::class,
//    UsPoliticsNewsEntity::class,WorldNewsEntity::class
)
@TypeConverters(NewsTypeConverter::class)
abstract class NewsDatabase: RoomDatabase() {

    abstract fun articleDao():ArticleDao

}