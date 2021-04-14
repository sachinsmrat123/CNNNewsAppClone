package com.example.cnn_news_app.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cnn_news_app.R
import kotlinx.android.synthetic.main.activity_alerts_that_matter.*

class AlertsThatMatter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alerts_that_matter)

        btDone.setOnClickListener {
            intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}