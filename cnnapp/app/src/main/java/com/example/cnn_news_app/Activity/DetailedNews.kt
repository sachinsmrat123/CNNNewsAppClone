package com.example.cnn_news_app.Activity

import android.content.Intent
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cnn_news_app.R
import com.example.cnn_news_app.data.model.Article
import com.example.cnn_news_app.data.model.Source
import com.example.cnn_news_app.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_detailed_news.*


@AndroidEntryPoint
class DetailedNews : AppCompatActivity() {
    var link:String?=null
    var imageUrl:String? =null
    var title:String? =null
    var content:String? =null
    var by:String? =null
    var time:String? =null
    var author:String? =null
    var source:Source?= null
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_news)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        link=intent.getStringExtra("newsUrl")
        imageUrl = intent.getStringExtra("image")
        title = intent.getStringExtra("title")
        by = intent.getStringExtra("by")
        time = intent.getStringExtra("time")
         content = intent.getStringExtra("content")
         author = intent.getStringExtra("author")


        webView.loadUrl(link!!)
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        ////setting data
//        Glide.with(tvNewsImageDetailed).load(imageUrl).into(tvNewsImageDetailed)
//        tvTitleDetailed.text=title
//        tvPublisherDetailed.text=by
//        tvUpdateTime.text=time
//        tvContentDetailed.text=content

        newsBackButton.setOnClickListener {
            finish()
        }

        btnShareInDetails.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            var body = link
            var sub = "Cnn News";
            intent.putExtra(Intent.EXTRA_SUBJECT,sub);
            intent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(Intent.createChooser(intent, "Share Using"))

        }
//        btnSaveInDetails.setOnClickListener {
//            var article = Article(0,0,author,content,"","", source,title,link,imageUrl)
//            if (article.saved == 0) {
//                mainViewModel.saveArticle(article)
//                btnSaveInDetails.setImageResource(R.drawable.ic_saved_filled_red)
//                article.saved = 1
//
//            } else {
//                mainViewModel.deleteArticle(article)
//                btnSaveInDetails.setImageResource(R.drawable.ic_bookmark)
//                article.saved = 0
//            }
//        }
    }
}