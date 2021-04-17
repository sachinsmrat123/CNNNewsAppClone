package com.example.cnn_news_app.data.network


import com.example.cnn_news_app.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {


//    @GET("v2/top-headlines")
//    suspend fun getTopNews(
//        @Query("country")
//        countryCode:String = "in",
//        @Query("apiKey")
//        apiKey:String = "8b88078f00054b9cbeb4786b4d368590"
//    ):Response<NewsResponse>

    @GET("cnn/breakingnews")
    suspend fun getTopNews(
//        @Query("q")
//        searchQuery:String="apple",
//        @Query("apiKey")
//        apiKey:String = "48594a7cff5341469f3f0faedcbf115b"
    ):Response<NewsResponse>

}