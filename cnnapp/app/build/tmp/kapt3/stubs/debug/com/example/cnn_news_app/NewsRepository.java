package com.example.cnn_news_app;

import java.lang.System;

@dagger.hilt.android.scopes.ActivityRetainedScoped()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/example/cnn_news_app/NewsRepository;", "", "newsApi", "Lcom/example/cnn_news_app/data/network/NewsApi;", "(Lcom/example/cnn_news_app/data/network/NewsApi;)V", "getTopNews", "Lretrofit2/Response;", "Lcom/example/cnn_news_app/model/NewsResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class NewsRepository {
    private final com.example.cnn_news_app.data.network.NewsApi newsApi = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTopNews(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.cnn_news_app.model.NewsResponse>> p0) {
        return null;
    }
    
    @javax.inject.Inject()
    public NewsRepository(@org.jetbrains.annotations.NotNull()
    com.example.cnn_news_app.data.network.NewsApi newsApi) {
        super();
    }
}