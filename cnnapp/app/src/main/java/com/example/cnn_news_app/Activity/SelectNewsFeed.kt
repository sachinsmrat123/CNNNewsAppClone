package com.example.cnn_news_app.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.cnn_news_app.R


class SelectNewsFeed : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_news_feed)
        var button1 = 1;
        var button2=1;
        val mLlUsEdition: LinearLayout = findViewById(R.id.llUsEdition)
        val mLlInternational: LinearLayout = findViewById(R.id.llInternational)
        val mTvUsEdition: TextView = findViewById(R.id.tvUsEdition)
        val mTvInternational: TextView = findViewById(R.id.tvInternational)
        val mBtNext: Button = findViewById(R.id.btNext)

        mLlUsEdition.setOnClickListener {
            if(button1==1){
                mTvUsEdition.setTextColor(R.color.red)
                mLlUsEdition.setBackgroundResource(R.drawable.orangle_background)
                button1=2
            }else if(button1==2){
                mTvUsEdition.setTextColor(R.color.black)
                mLlUsEdition.setBackgroundResource(R.drawable.gray_background_round)
                button1=1
            }
        }

        mLlInternational.setOnClickListener {
            if(button2==1){
                mTvInternational.setTextColor(R.color.red)
                mLlInternational.setBackgroundResource(R.drawable.orangle_background)
                button2=2;
            }else if(button2==2){
                mTvInternational.setTextColor(R.color.black)
                mLlInternational.setBackgroundResource(R.drawable.gray_background_round)
                button2=1;
            }
        }

        mBtNext.setOnClickListener {
           intent=Intent(this, AlertsThatMatter::class.java)
            startActivity(intent)
        }
    }
}