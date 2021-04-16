package com.example.cnn_news_app

import androidx.lifecycle.LiveData
import com.example.cnn_news_app.data.database.ArticleDao
import com.example.cnn_news_app.data.database.cache.entity.TopNewsEntity
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

    suspend fun getTopNews():Response<NewsResponse>{
        return newsApi.getTopNews()
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

    suspend fun insertTopNewsForCache(topNewsEntity: TopNewsEntity){
        articleDao.insertTopNewsForCache(topNewsEntity)

    }

    fun getCacheTopNews(): LiveData<List<TopNewsEntity>>{
        return articleDao.getCacheTopNews()
    }


}