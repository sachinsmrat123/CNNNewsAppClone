package com.example.cnn_news_app.view.fragments.category

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cnn_news_app.*
import com.example.cnn_news_app.model.Article
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_top_news.*


@AndroidEntryPoint
class TopNewsFragment : Fragment(),ItemClickListener{

    private lateinit var mainViewModel:MainViewModel
    private lateinit var mTopNewsAdapter:NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        mTopNewsAdapter = NewsAdapter(this)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_top_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.getTopNews()
        mainViewModel.topNewsResponse.observe(viewLifecycleOwner, Observer {

            Log.d("response", "onViewCreated: $it ")
            when(it){
                is NetworkResult.Success ->{
                    rvTopNews.layoutManager = LinearLayoutManager(requireContext())
                    rvTopNews.adapter = mTopNewsAdapter
                    mTopNewsAdapter.setData(it.data!!.articles)
                    hideProgressBar()

                }
                is NetworkResult.Error -> {
                    hideProgressBar()
                    Toast.makeText(
                        requireContext(),
                        it.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is NetworkResult.Loading -> {
                    showProgressBar()
                }
            }
        })



    }

    private fun hideProgressBar() {
        topNewsProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        topNewsProgressBar.visibility = View.VISIBLE
    }


    override fun onArticleClicked(article: Article) {

    }

    override fun onSavedButtonClicked(article: Article) {
       if(article.saved==0){
           mainViewModel.saveArticle(article)
           article.saved=1

       }else{
           mainViewModel.deleteArticle(article)
           article.saved=0
       }
    }

    override fun onShareButtonClicked(article: Article) {

    }


}