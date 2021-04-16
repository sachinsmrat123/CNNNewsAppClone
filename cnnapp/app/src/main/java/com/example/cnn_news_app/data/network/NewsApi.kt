package com.example.cnn_news_app.data.network


import com.example.cnn_news_app.model.NewsResponse
import com.example.cnn_news_app.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {


    //https://newsapi.org/v2/everything?country=us&apiKey=48594a7cff5341469f3f0faedcbf115b
    @GET("/v2/everything")
    suspend fun searchNews(
            @Query("q")
            searchQuery: String,
            @Query("apiKey")
            apiKey: String = API_KEY
    ): Response<NewsResponse>

//    https://newsapi.org/v2/top-headlines?country=us&apiKey=48594a7cff5341469f3f0faedcbf115b

    @GET("/v2/top-headlines")
    suspend fun getTopNews(
            @Query("country")
            countryCode: String = "us",
            @Query("apiKey")
            apiKey: String = API_KEY
    ): Response<NewsResponse>


    //https://newsapi.org/v2/everything?q=world&apiKey=48594a7cff5341469f3f0faedcbf115b
    @GET("/v2/everything")
    suspend fun getWorldNews(
            @Query("q")
            countryCode: String = "world",
            @Query("apiKey")
            apiKey: String = API_KEY
    ): Response<NewsResponse>


    //    https://newsapi.org/v2/top-headlines?country=us&category=politics&apiKey=48594a7cff5341469f3f0faedcbf115b

    @GET("/v2/top-headlines")
    suspend fun getUsPoliticsNews(
            @Query("country")
            countryCode: String = "us",
            @Query("category")
            category: String = "politics",
            @Query("apiKey")
            apiKey: String = API_KEY
    ): Response<NewsResponse>

//    https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=48594a7cff5341469f3f0faedcbf115b

    @GET("/v2/top-headlines")
    suspend fun getBusinessNews(
            @Query("country")
            countryCode: String = "us",
            @Query("category")
            category: String = "business",
            @Query("apiKey")
            apiKey: String = API_KEY
    ): Response<NewsResponse>


    //https://newsapi.org/v2/top-headlines?country=us&category=health&apiKey=48594a7cff5341469f3f0faedcbf115b

    @GET("/v2/top-headlines")
    suspend fun getHealthNews(
            @Query("country")
            countryCode: String = "us",
            @Query("category")
            category: String = "health",
            @Query("apiKey")
            apiKey: String = API_KEY
    ): Response<NewsResponse>

    //https://newsapi.org/v2/top-headlines?country=us&category=entertainment&apiKey=48594a7cff5341469f3f0faedcbf115b

    @GET("/v2/top-headlines")
    suspend fun getEntertainmentNews(
            @Query("country")
            countryCode:String = "us",
            @Query("category")
            category: String = "entertainment",
            @Query("apiKey")
            apiKey: String = API_KEY
    ): Response<NewsResponse>

    //https://newsapi.org/v2/top-headlines?country=us&category=sports&apiKey=48594a7cff5341469f3f0faedcbf115b

    @GET("/v2/top-headlines")
    suspend fun getSportsNews(
            @Query("country")
            countryCode:String = "us",
            @Query("category")
            category: String = "sports",
            @Query("apiKey")
            apiKey: String = API_KEY
    ): Response<NewsResponse>

}