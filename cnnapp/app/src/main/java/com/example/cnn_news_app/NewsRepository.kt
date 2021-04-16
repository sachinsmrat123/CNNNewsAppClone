package com.example.cnn_news_app

import androidx.lifecycle.LiveData
import com.example.cnn_news_app.data.database.ArticleDao
import com.example.cnn_news_app.data.database.cache.entity.*
import com.example.cnn_news_app.data.network.NewsApi
import com.example.cnn_news_app.model.Article
import com.example.cnn_news_app.model.NewsResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Response
import javax.inject.Inject


@ActivityRetainedScoped
class NewsRepository @Inject constructor(
    private val newsApi: NewsApi,
    private val articleDao: ArticleDao
){

    suspend fun searchNews(searchQuery:String):Response<NewsResponse>{
        return newsApi.searchNews(searchQuery)
    }

    suspend fun getTopNews():Response<NewsResponse>{
        return newsApi.getTopNews()
    }
    suspend fun getWorldNews():Response<NewsResponse>{
        return newsApi.getWorldNews()
    }
    suspend fun getUsPoliticsNews():Response<NewsResponse>{
        return newsApi.getUsPoliticsNews()
    }
    suspend fun getBusinessNews():Response<NewsResponse>{
        return newsApi.getBusinessNews()
    }
    suspend fun getHealthNews():Response<NewsResponse>{
        return newsApi.getHealthNews()
    }
    suspend fun getEntertainmentNews():Response<NewsResponse>{
        return newsApi.getEntertainmentNews()
    }
    suspend fun getSportsNews():Response<NewsResponse>{
        return newsApi.getSportsNews()
    }


    suspend fun saveArticles(article: Article){
        articleDao.insert(article)
    }

    fun getAllArticles(): LiveData<List<Article>>{
        return articleDao.getAllArticles()
    }

    suspend fun deleteArticle(article: Article){
        articleDao.deleteArticle(article)
    }

    suspend fun deleteAllArticle(){
        articleDao.deleteAllArticles()
    }


    /** CACHE */

    suspend fun insertTopNewsForCache(topNewsEntity: TopNewsEntity){
        articleDao.insertTopNewsForCache(topNewsEntity)

    }

    fun getCacheTopNews(): LiveData<List<TopNewsEntity>>{
        return articleDao.getCacheTopNews()
    }

    suspend fun insertWorldNewsForCache(worldNewsEntity: WorldNewsEntity){
        articleDao.insertWorldNewsForCache(worldNewsEntity)

    }

    fun getCacheWorldNews():LiveData<List<WorldNewsEntity>>{
        return articleDao.getCacheWorldNews()
    }

    suspend fun insertUsPoliticsNewsForCache(usPoliticsNewsEntity: UsPoliticsNewsEntity){
        articleDao.insertUsPoliticsNewsForCache(usPoliticsNewsEntity)

    }

    fun getCacheUsPoliticsNews():LiveData<List<UsPoliticsNewsEntity>>{
        return articleDao.getCacheUsPoliticsNews()
    }

    suspend fun insertBusinessNewsForCache(businessNewsEntity: BusinessNewsEntity){
        articleDao.insertBusinessNewsForCache(businessNewsEntity)

    }

    fun getCacheBusinessNews():LiveData<List<BusinessNewsEntity>>{
        return articleDao.getCacheBusinessNews()
    }

    suspend fun insertHealthNewsForCache(healthNewsEntity: HealthNewsEntity){
        articleDao.insertHealthNewsForCache(healthNewsEntity)

    }

    fun getCacheHealthNews():LiveData<List<HealthNewsEntity>>{
        return articleDao.getCacheHealthNews()
    }

    suspend fun insertEntertainmentNewsForCache(entertainmentNewsEntity: EntertainmentNewsEntity){
        articleDao.insertEntertainmentNewsForCache(entertainmentNewsEntity)

    }

    fun getCacheEntertainmentNews():LiveData<List<EntertainmentNewsEntity>>{
        return articleDao.getCacheEntertainmentNews()
    }

    suspend fun insertSportsNewsForCache(sportsNewsEntity: SportsNewsEntity){
        articleDao.insertSportsNewsForCache(sportsNewsEntity)

    }

    fun getCacheSportsNews():LiveData<List<SportsNewsEntity>>{
        return articleDao.getCacheSportsNews()
    }


}