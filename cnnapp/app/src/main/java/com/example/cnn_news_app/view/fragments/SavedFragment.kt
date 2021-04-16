package com.example.cnn_news_app.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cnn_news_app.ItemClickListener
import com.example.cnn_news_app.MainViewModel
import com.example.cnn_news_app.NewsAdapter
import com.example.cnn_news_app.R
import com.example.cnn_news_app.model.Article
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_saved.*
import kotlinx.android.synthetic.main.fragment_top_news.*

@AndroidEntryPoint
class SavedFragment : Fragment(), ItemClickListener {
    private lateinit var mainViewModel: MainViewModel
    private var articles = listOf<Article>()
    private lateinit var mSavedNewsAdapter:NewsAdapter

//    private val mSavedNewsAdapter by lazy { NewsAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        mSavedNewsAdapter = NewsAdapter(articles,this);


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.getAllSavedArticles().observe(viewLifecycleOwner, Observer {

            rvSaved.layoutManager = LinearLayoutManager(requireContext())
            rvSaved.adapter = mSavedNewsAdapter
            mSavedNewsAdapter.setData(it)
        })
    }



    override fun onArticleClicked(article: Article) {
    }

    override fun onSavedButtonClicked(article: Article) {
    }

    override fun onShareButtonClicked(article: Article) {
    }

}