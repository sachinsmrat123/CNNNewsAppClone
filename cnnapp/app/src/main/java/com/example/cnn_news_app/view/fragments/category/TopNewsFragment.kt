package com.example.cnn_news_app.view.fragments.category

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cnn_news_app.*
import com.example.cnn_news_app.Activity.PaginationScrollListener
import com.example.cnn_news_app.model.Article
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_top_news.*


@AndroidEntryPoint
class TopNewsFragment : Fragment(),ItemClickListener{

    private lateinit var mainViewModel:MainViewModel
    private lateinit var mTopNewsAdapter:NewsAdapter

    private val TAG: String = TopNewsFragment::class.java.getSimpleName()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        printLogs("onCreate");

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        printLogs("onCreateView")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        printLogs("onViewCreated");
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        mTopNewsAdapter = NewsAdapter(this)
        mainViewModel.getTopNews()

        rvTopNews.layoutManager = LinearLayoutManager(requireContext())
        rvTopNews.adapter = mTopNewsAdapter
            mainViewModel.topNewsResponse.observe(viewLifecycleOwner, Observer {
                Log.d("response", "onViewCreated: $it ")
                when (it) {
                    is NetworkResult.Success -> {
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
           article.saved=1
           mainViewModel.saveArticle(article)

       }else{
           article.saved=0
           mainViewModel.deleteArticle(article)
       }
    }

    override fun onShareButtonClicked(article: Article) {

    }


    override fun onStart() {
        super.onStart()
        printLogs("onStart")
    }

    override fun onResume() {
        super.onResume()
        printLogs("onResume")
    }

    override fun onPause() {
        super.onPause()
        printLogs("onPause")
    }

    override fun onStop() {
        super.onStop()
        printLogs("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        printLogs("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        printLogs("onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        printLogs("onDetach")
    }

    private fun printLogs(message: String) {
        Log.d(TAG, message)
    }

}