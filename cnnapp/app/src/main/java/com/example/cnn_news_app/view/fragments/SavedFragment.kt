package com.example.cnn_news_app.view.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cnn_news_app.*
import com.example.cnn_news_app.Activity.DetailedNews
import com.example.cnn_news_app.adapters.SavedItemClickListener
import com.example.cnn_news_app.adapters.SavedNewsAdapter
import com.example.cnn_news_app.data.model.Article
import com.example.cnn_news_app.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_saved.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SavedFragment : Fragment(), SavedItemClickListener {
    private lateinit var mainViewModel: MainViewModel
    private var articles = listOf<Article>()
    private lateinit var mSavedNewsAdapter: SavedNewsAdapter

//    private val mSavedNewsAdapter by lazy { NewsAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        mSavedNewsAdapter = SavedNewsAdapter(articles, this);


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
        mainViewModel.getAllSavedArticles().observe(viewLifecycleOwner, Observer {data->

            rvSaved.layoutManager = LinearLayoutManager(requireContext())
            rvSaved.adapter = mSavedNewsAdapter

            if (data.isNotEmpty()) {
                rvSaved.visibility = View.VISIBLE
                btnDeleteAll.visibility = View.VISIBLE
                ivNoSavedArticle.visibility = View.INVISIBLE
                bgImage.visibility = View.INVISIBLE
                mSavedNewsAdapter.setData(data)
            } else {
                rvSaved.visibility = View.INVISIBLE
                btnDeleteAll.visibility = View.INVISIBLE
                ivNoSavedArticle.visibility = View.VISIBLE
                bgImage.visibility = View.VISIBLE
            }


        })

        btnDeleteAll.setOnClickListener {

            val builder = AlertDialog.Builder(requireContext())

            builder.setTitle(R.string.dialogTitleForDeleteAll)

            builder.setMessage(R.string.dialogMessageForDeleteAll)

            builder.setPositiveButton("REMOVE"){dialogInterface, which ->

                CoroutineScope(Dispatchers.IO).launch {

                    mainViewModel.deleteAllArticle()

                }

            }
            builder.setNegativeButton("CANCEL"){dialogInterface, which ->

            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(true)
            alertDialog.show()
        }
    }

    override fun onArticleClicked(article: Article) {

        val intent= Intent(context, DetailedNews::class.java)
        intent.putExtra("newsUrl",article.url)
        startActivity(intent)
    }

    override fun onDeleteButtonClicked(article: Article) {
        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle(R.string.dialogTitleForDeleteAll)

        builder.setMessage(R.string.dialogMessageForDeleteAll)

        builder.setPositiveButton("REMOVE"){dialogInterface, which ->

            CoroutineScope(Dispatchers.IO).launch {

                mainViewModel.deleteArticle(article)

            }

        }
        builder.setNegativeButton("CANCEL"){dialogInterface, which ->

        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(true)
        alertDialog.show()

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