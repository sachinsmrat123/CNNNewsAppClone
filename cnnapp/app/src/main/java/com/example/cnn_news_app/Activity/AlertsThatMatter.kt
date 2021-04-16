package com.example.cnn_news_app.Activity

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.cnn_news_app.MainActivity
import com.example.cnn_news_app.R


class AlertsThatMatter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alerts_that_matter)
        val mBtDone:Button = findViewById(R.id.btDone)




        mBtDone.setOnClickListener {

            intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}