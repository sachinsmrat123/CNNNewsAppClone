package com.example.cnn_news_app.liveTv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cnn_news_app.R
import com.example.cnn_news_app.adapter.LiveNewsAdapter
import com.example.cnn_news_app.model.LiveNews
import kotlinx.android.synthetic.main.activity_live_tv.*

class liveTvActivity : AppCompatActivity() {
    private val VideoList = mutableListOf<LiveNews>()
    lateinit var liveNewsAdapter: LiveNewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_tv)

    }
    private fun setRecyclerAdapter() {
        liveNewsAdapter = LiveNewsAdapter(VideoList)
        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvLiveNews.layoutManager =linearLayoutManager
        rvLiveNews.adapter =liveNewsAdapter
    }
    private fun buildData() {
        VideoList.add(
            LiveNews(
                "exMSmXqEKKo",
                "2 hours ago",
                "https://img.etimg.com/thumb/msid-82076214,width-294,resizemode-4,imgsize-276016/coronavirus-news-and-updates-live-april-15.jpg",
                "Explained: Why the sudden shortage of Remdesivir and the way forward"
            )
        )
        VideoList.add(
            LiveNews(
                "H-I7H90-57I",
                "4 hours ago",
                "https://img.etimg.com/thumb/msid-69161193,width-445,resizemode-4,imgsize-181529/cyclone-fani-landfall-in-odisha-here-is-all-that-you-need-to-know.jpg",
                "Cyclone Fani batters Odisha: Dramatic visuals | Economic Times"
            )
        )
        VideoList.add(
            LiveNews(
                "8wHScEr8Cs8",
                "19 hours ago",
                "https://images.livemint.com/img/2021/04/12/600x338/AFP_97J3U3_1618227326985_1618227406153.jpg",
                "Sputnik V Vaccine: How effective could India's third Covid-19 vaccine be?"
            )
        )
        VideoList.add(
            LiveNews(
                "ecdrgZV0unA",
                "5 days ago ",
                "https://images.hindustantimes.com/img/2021/04/13/550x309/5a248b3a-658c-11eb-b803-eb9771c75b08_1618334406566_1618334428621.jpg",
                "Maharashtra: No lockdown but strict curbs imposed from April 14 including Sec 144, says CM Thackeray"
            )
        )
    }
}