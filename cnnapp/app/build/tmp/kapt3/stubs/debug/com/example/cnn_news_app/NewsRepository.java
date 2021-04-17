package com.example.cnn_news_app;

import java.lang.System;

@dagger.hilt.android.scopes.ActivityRetainedScoped()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\u000fJ\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00100\u000fJ\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/example/cnn_news_app/NewsRepository;", "", "newsApi", "Lcom/example/cnn_news_app/data/network/NewsApi;", "articleDao", "Lcom/example/cnn_news_app/data/database/ArticleDao;", "(Lcom/example/cnn_news_app/data/network/NewsApi;Lcom/example/cnn_news_app/data/database/ArticleDao;)V", "deleteAllArticle", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteArticle", "article", "Lcom/example/cnn_news_app/model/Article;", "(Lcom/example/cnn_news_app/model/Article;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllArticles", "Landroidx/lifecycle/LiveData;", "", "getCacheTopNews", "Lcom/example/cnn_news_app/data/database/cache/entity/TopNewsEntity;", "getTopNews", "Lretrofit2/Response;", "Lcom/example/cnn_news_app/model/NewsResponse;", "insertTopNewsForCache", "topNewsEntity", "(Lcom/example/cnn_news_app/data/database/cache/entity/TopNewsEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveArticles", "app_debug"})
public final class NewsRepository {
    private final com.example.cnn_news_app.data.network.NewsApi newsApi = null;
    private final com.example.cnn_news_app.data.database.ArticleDao articleDao = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTopNews(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.cnn_news_app.model.NewsResponse>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveArticles(@org.jetbrains.annotations.NotNull()
    com.example.cnn_news_app.model.Article article, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.cnn_news_app.model.Article>> getAllArticles() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteArticle(@org.jetbrains.annotations.NotNull()
    com.example.cnn_news_app.model.Article article, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteAllArticle(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertTopNewsForCache(@org.jetbrains.annotations.NotNull()
    com.example.cnn_news_app.data.database.cache.entity.TopNewsEntity topNewsEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.cnn_news_app.data.database.cache.entity.TopNewsEntity>> getCacheTopNews() {
        return null;
    }
    
    @javax.inject.Inject()
    public NewsRepository(@org.jetbrains.annotations.NotNull()
    com.example.cnn_news_app.data.network.NewsApi newsApi, @org.jetbrains.annotations.NotNull()
    com.example.cnn_news_app.data.database.ArticleDao articleDao) {
        super();
    }
}