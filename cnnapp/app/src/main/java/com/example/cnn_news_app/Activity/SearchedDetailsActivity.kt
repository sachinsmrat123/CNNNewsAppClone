package com.example.cnn_news_app.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cnn_news_app.R
import com.example.cnn_news_app.adapters.SearchedNewsDetailsAdapter
import com.example.cnn_news_app.adapters.SearchedNewsDetailsItemClickListener
import com.example.cnn_news_app.data.database.SearchedArticleEntity
import com.example.cnn_news_app.data.model.Article
import com.example.cnn_news_app.util.NetworkResult
import com.example.cnn_news_app.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_searched_details.*

@AndroidEntryPoint
class SearchedDetailsActivity : AppCompatActivity(),SearchedNewsDetailsItemClickListener {


    lateinit var mainViewModel: MainViewModel
    private lateinit var mSearchAdapter: SearchedNewsDetailsAdapter
    private var articles = listOf<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setContentView(R.layout.activity_searched_details)

        mSearchAdapter = SearchedNewsDetailsAdapter(articles, this)
        rvSearchDetails.layoutManager = LinearLayoutManager(this)
        rvSearchDetails.adapter = mSearchAdapter
        var searchQuery = intent.getStringExtra("searchString")

        searchViewDetails.setQuery(searchQuery, false)

        mainViewModel.getSearchNews(searchQuery!!)


        searchViewDetails.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(s: String): Boolean {

                return true
            }

            override fun onQueryTextSubmit(s: String): Boolean {
                if (s.isNotEmpty()){
                    var searchedArticleEntity = SearchedArticleEntity(s)
                    mainViewModel.insertSearchedNews(searchedArticleEntity)
                    mainViewModel.getSearchNews(s)
                }
                return true
            }
        })

        mainViewModel.searchNewsResponse.observe(this, Observer {
            showProgressBar()

            Log.d("response", "onViewCreated: $it ")
            when (it) {
                is NetworkResult.Success<*> -> {
                    hideProgressBar()
                    rvSearchDetails.visibility = View.VISIBLE
                    ivNoSearchResult.visibility = View.INVISIBLE
                    tvNoSearchResult.visibility = View.INVISIBLE
                    tvNoResultDesc.visibility = View.INVISIBLE

                    articles = it.data!!.articles
                    mSearchAdapter.setData(it.data?.articles!!)
                    tvTotalResults.text = "${it.data.totalResults.toString()} results"


                }
                is NetworkResult.Error<*> -> {
                    hideProgressBar()
                    rvSearchDetails.visibility = View.INVISIBLE
                    ivNoSearchResult.visibility = View.VISIBLE
                    tvNoSearchResult.visibility = View.VISIBLE
                    tvNoResultDesc.visibility = View.VISIBLE
                    Toast.makeText(
                        this,
                        it.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is NetworkResult.Loading<*> -> {

                    showProgressBar()
                }
            }
        })

        tvCancelInDetails.setOnClickListener {
            finish()
        }

    }

    private fun hideProgressBar() {
        if (searchedDetailsProgressBar != null) {
            searchedDetailsProgressBar.visibility = View.INVISIBLE
        }

    }

    private fun showProgressBar() {
        if (searchedDetailsProgressBar != null) {
            searchedDetailsProgressBar.visibility = View.VISIBLE
        }
    }

    override fun onSearchedItemClicked(article: Article) {
        val intent= Intent(this@SearchedDetailsActivity, DetailedNews::class.java)
        intent.putExtra("newsUrl",article.url)
        startActivity(intent)

    }
}