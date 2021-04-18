package com.example.cnn_news_app.view.fragments

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cnn_news_app.Activity.SearchedDetailsActivity
import com.example.cnn_news_app.R
import com.example.cnn_news_app.adapters.SavedSearchedItemClickListener
import com.example.cnn_news_app.adapters.SearchedSavedAdapter
import com.example.cnn_news_app.data.database.SearchedArticleEntity
import com.example.cnn_news_app.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_search.*


@AndroidEntryPoint
class SearchFragment : Fragment(),SavedSearchedItemClickListener {


    private lateinit var mainViewModel: MainViewModel
    private lateinit var mSaved:SearchedSavedAdapter
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
        mSaved = SearchedSavedAdapter(articles,this)

        rvSearchedSaved.layoutManager = LinearLayoutManager(requireContext())
        rvSearchedSaved.adapter = mSaved


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
                    tvClear.visibility = View.VISIBLE
                    val searchedArticleEntity = SearchedArticleEntity(s)
                    mainViewModel.insertSearchedNews(searchedArticleEntity)
                    val intent = Intent(requireContext(),SearchedDetailsActivity::class.java)
                    intent.putExtra("searchString",s)
                    startActivity(intent)

                }
                return true
            }
        })

        tvClear.setOnClickListener {
            mainViewModel.clearAllSearched()
            tvClear.visibility = View.INVISIBLE
        }

        tvCancle.setOnClickListener {
            view.hideKeyboard()
        }
    }

    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }


    override fun onSearchedItemClicked(searchedArticleEntity: SearchedArticleEntity) {
        val intent = Intent(requireContext(),SearchedDetailsActivity::class.java)
        intent.putExtra("searchString",searchedArticleEntity.searchedNews)
        startActivity(intent)
    }
}


