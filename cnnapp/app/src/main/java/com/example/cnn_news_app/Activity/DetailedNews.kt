package com.example.cnn_news_app.Activity

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.cnn_news_app.R
import kotlinx.android.synthetic.main.activity_detailed_news.*


class DetailedNews : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_news)

//        var imageUrl = intent.getStringExtra("image")
//        var title = intent.getStringExtra("title")
//        var by = intent.getStringExtra("by")
//        var time = intent.getStringExtra("time")
//        var content = intent.getStringExtra("content")
        var link=intent.getStringExtra("newsUrl")
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
    }
}