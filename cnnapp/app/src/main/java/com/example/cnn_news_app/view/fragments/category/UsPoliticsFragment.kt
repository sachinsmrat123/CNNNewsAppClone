package com.example.cnn_news_app.view.fragments.category

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.cnn_news_app.*
import com.example.cnn_news_app.Activity.DetailedNews
import com.example.cnn_news_app.adapters.ItemClickListener
import com.example.cnn_news_app.adapters.NewsAdapter
import com.example.cnn_news_app.data.model.Article
import com.example.cnn_news_app.util.NetworkResult
import com.example.cnn_news_app.util.observeOnce
import com.example.cnn_news_app.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_us_politics.*
import kotlinx.coroutines.launch


class UsPoliticsFragment : Fragment(), ItemClickListener {
    private lateinit var swipeRefresh: SwipeRefreshLayout
    var count = 0
    private lateinit var mainViewModel: MainViewModel
    private lateinit var mUsPoliticsNewsAdapter: NewsAdapter
    private var articles = listOf<Article>()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_us_politics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        mUsPoliticsNewsAdapter = NewsAdapter(articles, this);

        rvUsPolitics.adapter = mUsPoliticsNewsAdapter
        rvUsPolitics.layoutManager = LinearLayoutManager(requireContext())
//        showProgressBar()
        swipeRefresh= view.findViewById(R.id.swiperefresh_items)
        swipeRefresh.setOnRefreshListener {
            requestApiData()
        }
        requestApiData()

//        lifecycleScope.launchWhenStarted {
//            readDatabase()
//        }
    }

    private fun readDatabase() {
        lifecycleScope.launch {

            mainViewModel.getCacheUsPoliticsNews.observeOnce(viewLifecycleOwner, Observer { database ->
                if (database.isNotEmpty()) {
                    Log.d("TopNewsFragment", "readDatabase called!")
                    mUsPoliticsNewsAdapter.setData(database[0].newsResponse.articles)
                    hideProgressBar()
                }
            })
        }
    }

    private fun loadDataFromCache() {
        lifecycleScope.launch {
            if (view != null) {
                mainViewModel.getCacheUsPoliticsNews.observe(viewLifecycleOwner, Observer { cachedata ->
                    if (cachedata.isNotEmpty()) {
                        mUsPoliticsNewsAdapter.setData(cachedata[0].newsResponse.articles)
                    } else {
                        showProgressBar()
                    }
                })
            }

        }
    }

    private fun requestApiData() {

        mainViewModel.getUsPoliticsNews()
        if(swipeRefresh.isRefreshing){
            swipeRefresh.isRefreshing = false
        }
        mainViewModel.usPoliticsNewsResponse.observe(requireActivity(), Observer {

            Log.d("response", "onViewCreated: $it ")
            when (it) {
                is NetworkResult.Success -> {

                    hideProgressBar()
                    articles = it.data!!.articles
                    mUsPoliticsNewsAdapter.setData(articles)

                }
                is NetworkResult.Error -> {
                    hideProgressBar()
                    loadDataFromCache()
                    Toast.makeText(
                            requireContext(),
                            it.message.toString(),
                            Toast.LENGTH_SHORT
                    ).show()
                }
                is NetworkResult.Loading -> {
                    if (count == 0) {
                        loadDataFromCache()
                    }
                    count++
//                    showProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar() {
        if (usPoliticsProgressBar != null) {
            usPoliticsProgressBar.visibility = View.INVISIBLE
        }

    }

    private fun showProgressBar() {
        if (usPoliticsProgressBar != null) {
            usPoliticsProgressBar.visibility = View.VISIBLE
        }
    }


    override fun onArticleClicked(article: Article) {
        val intent= Intent(context, DetailedNews::class.java)
        intent.putExtra("newsUrl",article.url)
        startActivity(intent)
    }

    override fun onSavedButtonClicked(article: Article) {
        if (article.saved == 0) {
            mainViewModel.saveArticle(article)
            article.saved = 1

        } else {
            mainViewModel.deleteArticle(article)
            article.saved = 0
        }

    }

    override fun onShareButtonClicked(article: Article) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        var body = article.url;
        var sub = "Cnn News";
        intent.putExtra(Intent.EXTRA_SUBJECT,sub);
        intent.putExtra(Intent.EXTRA_TEXT,body);
        startActivity(Intent.createChooser(intent, "Share Using"))
    }

}