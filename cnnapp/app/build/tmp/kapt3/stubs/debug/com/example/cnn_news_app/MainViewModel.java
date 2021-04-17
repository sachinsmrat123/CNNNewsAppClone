package com.example.cnn_news_app;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\t0\bJ\u0011\u0010\u001b\u001a\u00020\u0016H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0016J\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100 H\u0002J\b\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0010H\u0002J\u000e\u0010%\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lcom/example/cnn_news_app/MainViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "repository", "Lcom/example/cnn_news_app/NewsRepository;", "application", "Landroid/app/Application;", "(Lcom/example/cnn_news_app/NewsRepository;Landroid/app/Application;)V", "getCacheTopNews", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/cnn_news_app/data/database/cache/entity/TopNewsEntity;", "getGetCacheTopNews", "()Landroidx/lifecycle/LiveData;", "topNewsResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/cnn_news_app/NetworkResult;", "Lcom/example/cnn_news_app/model/NewsResponse;", "getTopNewsResponse", "()Landroidx/lifecycle/MutableLiveData;", "setTopNewsResponse", "(Landroidx/lifecycle/MutableLiveData;)V", "deleteAllArticle", "", "deleteArticle", "article", "Lcom/example/cnn_news_app/model/Article;", "getAllSavedArticles", "getNewsSafeCall", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopNews", "handleNewsResponse", "response", "Lretrofit2/Response;", "hasInternetConnection", "", "insertTopNewsForCache", "news", "saveArticle", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.AndroidViewModel {
    
    /**
     * Retrofit
     */
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.example.cnn_news_app.NetworkResult<com.example.cnn_news_app.model.NewsResponse>> topNewsResponse;
    
    /**
     * Cache
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.cnn_news_app.data.database.cache.entity.TopNewsEntity>> getCacheTopNews = null;
    private final com.example.cnn_news_app.NewsRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.cnn_news_app.NetworkResult<com.example.cnn_news_app.model.NewsResponse>> getTopNewsResponse() {
        return null;
    }
    
    public final void setTopNewsResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.example.cnn_news_app.NetworkResult<com.example.cnn_news_app.model.NewsResponse>> p0) {
    }
    
    public final void getTopNews() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.cnn_news_app.data.database.cache.entity.TopNewsEntity>> getGetCacheTopNews() {
        return null;
    }
    
    private final void insertTopNewsForCache(com.example.cnn_news_app.model.NewsResponse news) {
    }
    
    private final com.example.cnn_news_app.NetworkResult<com.example.cnn_news_app.model.NewsResponse> handleNewsResponse(retrofit2.Response<com.example.cnn_news_app.model.NewsResponse> response) {
        return null;
    }
    
    private final boolean hasInternetConnection() {
        return false;
    }
    
    /**
     * ROOM DATABASE
     */
    public final void saveArticle(@org.jetbrains.annotations.NotNull()
    com.example.cnn_news_app.model.Article article) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.cnn_news_app.model.Article>> getAllSavedArticles() {
        return null;
    }
    
    public final void deleteArticle(@org.jetbrains.annotations.NotNull()
    com.example.cnn_news_app.model.Article article) {
    }
    
    public final void deleteAllArticle() {
    }
    
    @javax.inject.Inject()
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.example.cnn_news_app.NewsRepository repository, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
}