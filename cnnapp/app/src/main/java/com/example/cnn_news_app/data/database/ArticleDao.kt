package com.example.cnn_news_app.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cnn_news_app.data.database.cache.entity.*
import com.example.cnn_news_app.data.model.Article


@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Query("SELECT * FROM articlesTable ORDER BY id ASC")
    fun getAllArticles():LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)

    @Query("DELETE FROM articlesTable")
    fun deleteAllArticles()

    /** FOR CACHE */



    /** top news */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopNewsForCache(topNewsEntity: TopNewsEntity)

    @Query("SELECT * FROM Top_News_Table_cache ORDER BY id ASC")
    fun getCacheTopNews():LiveData<List<TopNewsEntity>>


    /** world news */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorldNewsForCache(worldNewsEntity: WorldNewsEntity)

    @Query("SELECT * FROM World_News_Table_cache ORDER BY id ASC")
    fun getCacheWorldNews():LiveData<List<WorldNewsEntity>>

    /** us politics */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsPoliticsNewsForCache(usPoliticsNewsEntity: UsPoliticsNewsEntity)

    @Query("SELECT * FROM Us_Politics_News_Table_cache ORDER BY id ASC")
    fun getCacheUsPoliticsNews():LiveData<List<UsPoliticsNewsEntity>>

    /** business news */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBusinessNewsForCache(businessNewsEntity: BusinessNewsEntity)

    @Query("SELECT * FROM Business_News_Table_cache ORDER BY id ASC")
    fun getCacheBusinessNews():LiveData<List<BusinessNewsEntity>>

    /** health news */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHealthNewsForCache(healthNewsEntity: HealthNewsEntity)

    @Query("SELECT * FROM health_news_table_cache ORDER BY id ASC")
    fun getCacheHealthNews():LiveData<List<HealthNewsEntity>>

    /** entertainment news */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntertainmentNewsForCache(entertainmentNewsEntity: EntertainmentNewsEntity)

    @Query("SELECT * FROM Entertainment_News_Table_cache ORDER BY id ASC")
    fun getCacheEntertainmentNews():LiveData<List<EntertainmentNewsEntity>>

    /** sports news */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSportsNewsForCache(sportsNewsEntity: SportsNewsEntity)

    @Query("SELECT * FROM Sports_News_Table_cache ORDER BY id ASC")
    fun getCacheSportsNews():LiveData<List<SportsNewsEntity>>

}