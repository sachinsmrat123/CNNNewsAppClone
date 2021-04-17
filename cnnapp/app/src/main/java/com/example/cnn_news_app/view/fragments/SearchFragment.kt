package com.example.cnn_news_app.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cnn_news_app.Activity.SearchedDetailsActivity
import com.example.cnn_news_app.R
import com.example.cnn_news_app.adapters.NewsAdapter
import com.example.cnn_news_app.adapters.SavedSearchedAdapter
import com.example.cnn_news_app.adapters.SavedSearchedItemClickListener
import com.example.cnn_news_app.data.database.SearchedArticleEntity
import com.example.cnn_news_app.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_search.*

@AndroidEntryPoint
class SearchFragment : Fragment(),SavedSearchedItemClickListener {


    private lateinit var mainViewModel: MainViewModel
    private lateinit var mSaved:SavedSearchedAdapter
    private var articles = listOf<SearchedArticleEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvSearchedSaved.layoutManager = LinearLayoutManager(requireContext())
        rvSearchedSaved.adapter = SavedSearchedAdapter(articles, this);
        mSaved = SavedSearchedAdapter(articles, this);

        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        mainViewModel.getAllSavedSearched().observe(viewLifecycleOwner, Observer {
            mSaved.setData(it)
        })


        newsSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(s: String): Boolean {

                return true
            }

            override fun onQueryTextSubmit(s: String): Boolean {
                if (s.isNotEmpty()){
                    val searchedArticleEntity = SearchedArticleEntity(s)
                    mainViewModel.insertSearchedNews(searchedArticleEntity)
                    val intent = Intent(requireContext(),SearchedDetailsActivity::class.java)
                    intent.putExtra("searchString",s)
                    startActivity(intent)

                }
                return true
            }
        })
    }


    override fun onSearchedItemClicked(searchedArticleEntity: SearchedArticleEntity) {
        val intent = Intent(requireContext(),SearchedDetailsActivity::class.java)
        intent.putExtra("searchString",searchedArticleEntity.searchedNews)
        startActivity(intent)
    }
}