package com.example.cnn_news_app.data.database;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.example.cnn_news_app.data.database.NewsTypeConverter.class})
@androidx.room.Database(entities = {com.example.cnn_news_app.data.model.Article.class, com.example.cnn_news_app.data.database.cache.entity.TopNewsEntity.class, com.example.cnn_news_app.data.database.cache.entity.BusinessNewsEntity.class, com.example.cnn_news_app.data.database.cache.entity.EntertainmentNewsEntity.class, com.example.cnn_news_app.data.database.cache.entity.HealthNewsEntity.class, com.example.cnn_news_app.data.database.cache.entity.SportsNewsEntity.class, com.example.cnn_news_app.data.database.cache.entity.UsPoliticsNewsEntity.class, com.example.cnn_news_app.data.database.cache.entity.WorldNewsEntity.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/example/cnn_news_app/data/database/NewsDatabase;", "Landroidx/room/RoomDatabase;", "()V", "articleDao", "Lcom/example/cnn_news_app/data/database/ArticleDao;", "app_debug"})
public abstract class NewsDatabase extends androidx.room.RoomDatabase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.cnn_news_app.data.database.ArticleDao articleDao();
    
    public NewsDatabase() {
        super();
    }
}