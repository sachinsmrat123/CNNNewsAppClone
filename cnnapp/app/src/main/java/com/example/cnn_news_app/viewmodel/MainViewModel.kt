package com.example.cnn_news_app.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cnn_news_app.data.database.SearchedArticleEntity
import com.example.cnn_news_app.repository.NewsRepository
import com.example.cnn_news_app.data.database.cache.entity.*
import com.example.cnn_news_app.data.model.Article
import com.example.cnn_news_app.data.model.NewsResponse
import com.example.cnn_news_app.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
        private val repository: NewsRepository,
        application: Application
):AndroidViewModel(application) {


    /** Retrofit */
    var searchNewsResponse:MutableLiveData<NetworkResult<NewsResponse>> = MutableLiveData()
    var topNewsResponse:MutableLiveData<NetworkResult<NewsResponse>> = MutableLiveData()
    var worldNewsResponse:MutableLiveData<NetworkResult<NewsResponse>> = MutableLiveData()
    var usPoliticsNewsResponse:MutableLiveData<NetworkResult<NewsResponse>> = MutableLiveData()
    var businessNewsResponse:MutableLiveData<NetworkResult<NewsResponse>> = MutableLiveData()
    var healthNewsResponse:MutableLiveData<NetworkResult<NewsResponse>> = MutableLiveData()
    var entertainmentNewsResponse:MutableLiveData<NetworkResult<NewsResponse>> = MutableLiveData()
    var sportsResponse:MutableLiveData<NetworkResult<NewsResponse>> = MutableLiveData()


    fun getSearchNews(searchQuery:String){

        viewModelScope.launch(){

            searchNewsResponse.value = NetworkResult.Loading()
            if (hasInternetConnection()){

                try {
                    val response = repository.searchNews(searchQuery)
                    searchNewsResponse.value = handleNewsResponse(response)
//                    val news = searchNewsResponse.value!!.data

                }catch (e: Exception){
                    searchNewsResponse.value = NetworkResult.Error("News not found")
                }
            }else{
                searchNewsResponse.value = NetworkResult.Error("No Internet Connection")
            }
        }
    }

    fun getTopNews(){

        viewModelScope.launch(){

            topNewsResponse.value = NetworkResult.Loading()
            if (hasInternetConnection()){

                val response = repository.getTopNews()
                topNewsResponse.value = handleNewsResponse(response)
                val news = topNewsResponse.value!!.data
                if (news!=null){
                    insertTopNewsForCache(news)
                }
//                try {
//                    val response = repository.getTopNews()
//                    topNewsResponse.value = handleNewsResponse(response)
//                    val news = topNewsResponse.value!!.data
//                    if (news!=null){
//                        insertTopNewsForCache(news)
//                    }
//
//                }catch (e: Exception){
//                    topNewsResponse.value = NetworkResult.Error("News not found")
//                }
            }else{
                topNewsResponse.value = NetworkResult.Error("No Internet Connection")
            }
        }
    }



    fun getWorldNews(){

        viewModelScope.launch {

            worldNewsResponse.value = NetworkResult.Loading()
            if (hasInternetConnection()){

                try {
                    val response = repository.getWorldNews()
                    worldNewsResponse.value = handleNewsResponse(response)
                    val news = worldNewsResponse.value!!.data
                    if (news!=null){
                        insertWorldNewsForCache(news)
                    }

                }catch (e: Exception){
                    worldNewsResponse.value = NetworkResult.Error("News not found")
                }
            }else{
                worldNewsResponse.value = NetworkResult.Error("No Internet Connection")
            }
        }
    }

    fun getUsPoliticsNews(){

        viewModelScope.launch{

            usPoliticsNewsResponse.value = NetworkResult.Loading()
            if (hasInternetConnection()){

                try {
                    val response = repository.getUsPoliticsNews()
                    usPoliticsNewsResponse.value = handleNewsResponse(response)
                    val news = usPoliticsNewsResponse.value!!.data
                    if (news!=null){
                        insertUsPoliticsNewsForCache(news)
                    }

                }catch (e: Exception){
                    usPoliticsNewsResponse.value = NetworkResult.Error("News not found")
                }
            }else{
                usPoliticsNewsResponse.value = NetworkResult.Error("No Internet Connection")
            }
        }
    }

    fun getBusinessNews(){

        viewModelScope.launch {

            businessNewsResponse.value = NetworkResult.Loading()
            if (hasInternetConnection()){

                try {
                    val response = repository.getBusinessNews()
                    businessNewsResponse.value = handleNewsResponse(response)
                    val news = businessNewsResponse.value!!.data
                    if (news!=null){
                        insertBusinessNewsForCache(news)
                    }

                }catch (e: Exception){
                    businessNewsResponse.value = NetworkResult.Error("News not found")
                }
            }else{
                businessNewsResponse.value = NetworkResult.Error("No Internet Connection")
            }
        }
    }
    fun getHealthNews(){

        viewModelScope.launch {

            healthNewsResponse.value = NetworkResult.Loading()
            if (hasInternetConnection()){

                try {
                    val response = repository.getHealthNews()
                    healthNewsResponse.value = handleNewsResponse(response)
                    val news = healthNewsResponse.value!!.data
                    if (news!=null){
                        insertHealthNewsForCache(news)
                    }

                }catch (e: Exception){
                    healthNewsResponse.value = NetworkResult.Error("News not found")
                }
            }else{
                healthNewsResponse.value = NetworkResult.Error("No Internet Connection")
            }
        }
    }

    fun getEntertainmentNews(){

        viewModelScope.launch {

            entertainmentNewsResponse.value = NetworkResult.Loading()
            if (hasInternetConnection()){

                try {
                    val response = repository.getEntertainmentNews()
                    entertainmentNewsResponse.value = handleNewsResponse(response)
                    val news = entertainmentNewsResponse.value!!.data
                    if (news!=null){
                        insertEntertainmentNewsForCache(news)
                    }

                }catch (e: Exception){
                    entertainmentNewsResponse.value = NetworkResult.Error("News not found")
                }
            }else{
                entertainmentNewsResponse.value = NetworkResult.Error("No Internet Connection")
            }
        }
    }

    fun getSportsNews(){

        viewModelScope.launch {

            sportsResponse.value = NetworkResult.Loading()
            if (hasInternetConnection()){

                try {
                    val response = repository.getSportsNews()
                    sportsResponse.value = handleNewsResponse(response)
                    val news = sportsResponse.value!!.data
                    if (news!=null){
                        insertSportsNewsForCache(news)
                    }

                }catch (e: Exception){
                    sportsResponse.value = NetworkResult.Error("News not found")
                }
            }else{
                sportsResponse.value = NetworkResult.Error("No Internet Connection")
            }
        }
    }





    /** Cache */

    val getCacheTopNews: LiveData<List<TopNewsEntity>> = repository.getCacheTopNews()
    val getCacheWorldNews: LiveData<List<WorldNewsEntity>> = repository.getCacheWorldNews()
    val getCacheUsPoliticsNews: LiveData<List<UsPoliticsNewsEntity>> = repository.getCacheUsPoliticsNews()
    val getCacheBusinessNews: LiveData<List<BusinessNewsEntity>> = repository.getCacheBusinessNews()
    val getCacheHealthNews: LiveData<List<HealthNewsEntity>> = repository.getCacheHealthNews()
    val getCacheEntertainmentNews: LiveData<List<EntertainmentNewsEntity>> = repository.getCacheEntertainmentNews()
    val getCacheSportsNews: LiveData<List<SportsNewsEntity>> = repository.getCacheSportsNews()


    private fun insertTopNewsForCache(news: NewsResponse) {
        val topNewsEntity = TopNewsEntity(news)

        viewModelScope.launch(Dispatchers.IO) {
            repository.insertTopNewsForCache(topNewsEntity)
        }
    }

    private fun insertWorldNewsForCache(news: NewsResponse) {
        val wordNewsEntity = WorldNewsEntity(news)

        viewModelScope.launch(Dispatchers.IO) {
            repository.insertWorldNewsForCache(wordNewsEntity)
        }
    }

    private fun insertUsPoliticsNewsForCache(news: NewsResponse) {
        val usPoliticsNewsEntity = UsPoliticsNewsEntity(news)

        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUsPoliticsNewsForCache(usPoliticsNewsEntity)
        }
    }

    private fun insertBusinessNewsForCache(news: NewsResponse){
        val businessNewsEntity = BusinessNewsEntity(news)

        viewModelScope.launch(Dispatchers.IO) {
            repository.insertBusinessNewsForCache(businessNewsEntity)
        }
    }

    private fun insertHealthNewsForCache(news: NewsResponse){
        val healthNewsEntity = HealthNewsEntity(news)

        viewModelScope.launch(Dispatchers.IO) {
            repository.insertHealthNewsForCache(healthNewsEntity)
        }
    }

    private fun insertEntertainmentNewsForCache(news: NewsResponse){
        val entertainmentNewsEntity = EntertainmentNewsEntity(news)

        viewModelScope.launch(Dispatchers.IO) {
            repository.insertEntertainmentNewsForCache(entertainmentNewsEntity)
        }
    }

    private fun insertSportsNewsForCache(news: NewsResponse){
        val sportsNewsEntity = SportsNewsEntity(news)

        viewModelScope.launch(Dispatchers.IO) {
            repository.insertSportsNewsForCache(sportsNewsEntity)
        }
    }

    /** ROOM DATABASE */

    fun saveArticle(article: Article){
        viewModelScope.launch(Dispatchers.IO){
            repository.saveArticles(article)
        }
    }

    fun getAllSavedArticles():LiveData<List<Article>>{
        return repository.getAllArticles()
    }
    fun deleteArticle(article: Article){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteArticle(article)
        }
    }

    fun deleteAllArticle(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllArticle()
        }
    }

    // Search Saved

     fun insertSearchedNews(searchedArticleEntity: SearchedArticleEntity){
         viewModelScope.launch(Dispatchers.IO){
             repository.insertSearchedNews(searchedArticleEntity)
         }

    }

    fun getAllSavedSearched():LiveData<List<SearchedArticleEntity>>{
        return repository.getAllSavedSearched()
    }

    fun clearAllSearched(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.clearAllSearched()
        }

    }

    /** Handle Internet connection */
    private fun handleNewsResponse(response: Response<NewsResponse>): NetworkResult<NewsResponse>? {

        when{
            response.message().toString().contains("timeout")->{
                return NetworkResult.Error("Timeout")
            }
            response.message().toString().contains("apiKeyExhausted")->{
                return NetworkResult.Error(" API key has no more requests available")
            }
            response.code() ==429 -> {
                return NetworkResult.Error("Api Key Limited")
            }
            response.body()!!.articles.isNullOrEmpty() -> {
                return NetworkResult.Error("Articles not found.")
            }
            response.isSuccessful -> {
                val news = response.body()
                return NetworkResult.Success(news!!)
            }
            else -> {
                return NetworkResult.Error(response.message())
            }
        }
    }


    private fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<Application>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

}