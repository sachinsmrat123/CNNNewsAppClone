package com.example.cnn_news_app.data.database

import androidx.room.TypeConverter
import com.example.cnn_news_app.model.Source

class NewsTypeConverter {

    @TypeConverter
    fun fromSource(source: Source):String{
        return source.name

    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}