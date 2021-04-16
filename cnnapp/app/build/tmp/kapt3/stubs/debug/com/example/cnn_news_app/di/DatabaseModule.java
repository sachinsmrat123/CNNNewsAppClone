package com.example.cnn_news_app.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\n"}, d2 = {"Lcom/example/cnn_news_app/di/DatabaseModule;", "", "()V", "provideDao", "Lcom/example/cnn_news_app/data/database/ArticleDao;", "database", "Lcom/example/cnn_news_app/data/database/NewsDatabase;", "provideDatabase", "context", "Landroid/content/Context;", "app_debug"})
@dagger.Module()
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.cnn_news_app.di.DatabaseModule INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.cnn_news_app.data.database.NewsDatabase provideDatabase(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.cnn_news_app.data.database.ArticleDao provideDao(@org.jetbrains.annotations.NotNull()
    com.example.cnn_news_app.data.database.NewsDatabase database) {
        return null;
    }
    
    private DatabaseModule() {
        super();
    }
}