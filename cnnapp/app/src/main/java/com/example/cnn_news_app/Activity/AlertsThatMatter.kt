package com.example.cnn_news_app.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.cnn_news_app.MainActivity
import com.example.cnn_news_app.R
import com.example.cnn_news_app.databinding.ActivityAlertsThatMatterBinding


class AlertsThatMatter : AppCompatActivity() {
    private lateinit var binding: ActivityAlertsThatMatterBinding
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