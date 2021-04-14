package com.example.cnn_news_app

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cnn_news_app.model.NewsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
private val repository: NewsRepository,
application: Application
):AndroidViewModel(application) {


    var topNewsResponse:MutableLiveData<NetworkResult<NewsResponse>> = MutableLiveData()
    var breakingNewsResponse: NewsResponse? = null


    fun getTopNews(){
        viewModelScope.launch {
            getNewsSafeCall()
        }

    }


    private suspend fun getNewsSafeCall() {
        topNewsResponse.value = NetworkResult.Loading()
        if (hasInternetConnection()){

            try {
                val response = repository.getTopNews()
                topNewsResponse.value = handleNewsResponse(response)

            }catch (e: Exception){
                topNewsResponse.value = NetworkResult.Error("News not found")
            }

        }else{
            topNewsResponse.value = NetworkResult.Error("No Internet Connection")
        }
    }

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
                return NetworkResult.Error("Recipes not found.")
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