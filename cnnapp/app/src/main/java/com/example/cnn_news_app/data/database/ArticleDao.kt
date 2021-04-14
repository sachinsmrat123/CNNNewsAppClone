package com.example.cnn_news_app.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cnn_news_app.model.Article


@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article):Long

    @Query("SELECT * FROM articles")
    fun getAllArticles():LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)

    @Query("DELETE FROM articles")
    fun deleteAllArticles()
}