package com.example.cnn_news_app.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cnn_news_app.R
import kotlinx.android.synthetic.main.activity_select_news_feed.*

class SelectNewsFeed : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_news_feed)
        var button1 = 1;
        var button2=1;

        llUsEdition.setOnClickListener {
            if(button1==1){
                tvUsEdition.setTextColor(R.color.red)
                llUsEdition.setBackgroundResource(R.drawable.orangle_background)
                button1=2
            }else if(button1==2){
                tvUsEdition.setTextColor(R.color.black)
                llUsEdition.setBackgroundResource(R.drawable.gray_background_round)
                button1=1
            }
        }

        llInternational.setOnClickListener {
            if(button2==1){
                tvInternational.setTextColor(R.color.red)
                llInternational.setBackgroundResource(R.drawable.orangle_background)
                button2=2;
            }else if(button2==2){
                tvInternational.setTextColor(R.color.black)
                llInternational.setBackgroundResource(R.drawable.gray_background_round)
                button2=1;
            }
        }

        btNext.setOnClickListener {
           intent=Intent(this, AlertsThatMatter::class.java)
            startActivity(intent)
        }
    }
}