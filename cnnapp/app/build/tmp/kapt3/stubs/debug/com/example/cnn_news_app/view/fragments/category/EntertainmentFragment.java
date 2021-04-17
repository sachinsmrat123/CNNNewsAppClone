package com.example.cnn_news_app.view.fragments.category;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u001a\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010$\u001a\u00020\u0014H\u0002J\b\u0010%\u001a\u00020\u0014H\u0002J\b\u0010&\u001a\u00020\u0014H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/example/cnn_news_app/view/fragments/category/EntertainmentFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/cnn_news_app/adapters/ItemClickListener;", "()V", "articles", "", "Lcom/example/cnn_news_app/data/model/Article;", "count", "", "getCount", "()I", "setCount", "(I)V", "mEntertainmentNewsAdapter", "Lcom/example/cnn_news_app/adapters/NewsAdapter;", "mainViewModel", "Lcom/example/cnn_news_app/viewmodel/MainViewModel;", "swipeRefresh", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "hideProgressBar", "", "loadDataFromCache", "onArticleClicked", "article", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSavedButtonClicked", "onShareButtonClicked", "onViewCreated", "view", "readDatabase", "requestApiData", "showProgressBar", "app_debug"})
public final class EntertainmentFragment extends androidx.fragment.app.Fragment implements com.example.cnn_news_app.adapters.ItemClickListener {
    private androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefresh;
    private int count = 0;
    private com.example.cnn_news_app.viewmodel.MainViewModel mainViewModel;
    private com.example.cnn_news_app.adapters.NewsAdapter mEntertainmentNewsAdapter;
    private java.util.List<com.example.cnn_news_app.data.model.Article> articles;
    private java.util.HashMap _$_findViewCache;
    
    public final int getCount() {
        return 0;
    }
    
    public final void setCount(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void readDatabase() {
    }
    
    private final void loadDataFromCache() {
    }
    
    private final void requestApiData() {
    }
    
    private final void hideProgressBar() {
    }
    
    private final void showProgressBar() {
    }
    
    @java.lang.Override()
    public void onArticleClicked(@org.jetbrains.annotations.NotNull()
    com.example.cnn_news_app.data.model.Article article) {
    }
    
    @java.lang.Override()
    public void onSavedButtonClicked(@org.jetbrains.annotations.NotNull()
    com.example.cnn_news_app.data.model.Article article) {
    }
    
    @java.lang.Override()
    public void onShareButtonClicked(@org.jetbrains.annotations.NotNull()
    com.example.cnn_news_app.data.model.Article article) {
    }
    
    public EntertainmentFragment() {
        super();
    }
}