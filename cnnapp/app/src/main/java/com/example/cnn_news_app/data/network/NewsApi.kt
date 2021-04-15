package com.example.cnn_news_app.data.network


import com.example.cnn_news_app.model.NewsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {


    @GET("v2/top-headlines")
    suspend fun getTopNews(
        @Query("sources")
        countryCode:String = "techcrunch",
        @Query("apiKey")
        apiKey:String = "8b88078f00054b9cbeb4786b4d368590"
    ):Response<NewsResponse>


}