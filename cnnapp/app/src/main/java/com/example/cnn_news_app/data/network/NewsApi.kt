package com.example.cnn_news_app.data.network


import com.example.cnn_news_app.model.Article
import com.example.cnn_news_app.model.NewsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {


    @GET("/api/TopNews")
    suspend fun getTopNews(
//        @Query("sources")
//        countryCode:String = "cnn",
//        @Query("apiKey")
//        apiKey:String = "bb7380db2f8c4145ad67b3c8e96716df"
    ):Response<NewsResponse>

}