package com.example.cnn_news_app.data.database

import androidx.room.TypeConverter
import com.example.cnn_news_app.model.Article
import com.example.cnn_news_app.model.NewsResponse
import com.example.cnn_news_app.model.Source
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NewsTypeConverter {

    var gson = Gson()

    @TypeConverter
    fun newsResponseToString(newsResponse: NewsResponse): String {
        return gson.toJson(newsResponse)
    }

    @TypeConverter
    fun stringToNewsResponse(data: String): NewsResponse {
        val listType = object : TypeToken<NewsResponse>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun articleToString(article: Article): String {
        return gson.toJson(article)
    }

    @TypeConverter
    fun stringToArticle(data: String): Article {
        val listType = object : TypeToken<Article>() {}.type
        return gson.fromJson(data, listType)
    }


    @TypeConverter
    fun fromSource(source: Source):String{
        return source.name

    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}