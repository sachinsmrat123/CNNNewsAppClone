package com.example.cnn_news_app

import com.example.cnn_news_app.data.network.NewsApi
import com.example.cnn_news_app.model.NewsResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Response
import javax.inject.Inject


@ActivityRetainedScoped
class NewsRepository @Inject constructor(
    private val newsApi: NewsApi
){

    suspend fun getTopNews():Response<NewsResponse>{
        return newsApi.getTopNews()
    }

}