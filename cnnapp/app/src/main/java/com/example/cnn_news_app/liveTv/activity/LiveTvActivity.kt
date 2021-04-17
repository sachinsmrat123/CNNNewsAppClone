package com.example.cnn_news_app.liveTv.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cnn_news_app.R

import com.example.cnn_news_app.liveTv.adapter.LiveNewsAdapter
import com.example.cnn_news_app.model.LiveNews
import kotlinx.android.synthetic.main.activity_live_tv.*

class liveTvActivity : AppCompatActivity() {
    private val VideoList = mutableListOf<LiveNews>()
    private val VideoList2 = mutableListOf<LiveNews>()
    private val VideoList3 = mutableListOf<LiveNews>()
    private val VideoList4 = mutableListOf<LiveNews>()
    private val VideoList5 = mutableListOf<LiveNews>()
    lateinit var liveNewsAdapter: LiveNewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_tv)
        buildData()
        buildData2()
        buildData3()
        buildData4()
        buildData5()
        setRecyclerAdapter()
        setRecyclerAdapter2()
        setRecyclerAdapter3()
        setRecyclerAdapter4()
        setRecyclerAdapter5()
    }
    private fun setRecyclerAdapter() {
        liveNewsAdapter = LiveNewsAdapter(VideoList)
        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvLiveNews.layoutManager =linearLayoutManager
        rvLiveNews.adapter =liveNewsAdapter
    }

    private fun setRecyclerAdapter2() {
        liveNewsAdapter = LiveNewsAdapter(VideoList2)
        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvWorldNews.layoutManager =linearLayoutManager
        rvWorldNews.adapter =liveNewsAdapter
    }

    private fun setRecyclerAdapter3() {
        liveNewsAdapter = LiveNewsAdapter(VideoList3)
        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCovid_19News.layoutManager =linearLayoutManager
        rvCovid_19News.adapter =liveNewsAdapter
    }
    private fun setRecyclerAdapter4() {
        liveNewsAdapter = LiveNewsAdapter(VideoList4)
        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCnnDigitalWorldWideNews.layoutManager =linearLayoutManager
        rvCnnDigitalWorldWideNews.adapter =liveNewsAdapter
    }
    private fun setRecyclerAdapter5() {
        liveNewsAdapter = LiveNewsAdapter(VideoList5)
        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvWorldSupportNews.layoutManager =linearLayoutManager
        rvWorldSupportNews.adapter =liveNewsAdapter
    }
    private fun buildData() {

        VideoList.add(
            LiveNews(
                "exMSmXqEKKo",
                "2 hours ago",
                "https://cdn.cnn.com/cnnnext/dam/assets/210416012344-jonathan-mattingly-file-restricted-exlarge-169.jpg",
                "Simon & Schuster won't distribute book by a Louisville police officer involved in the Breonna Taylor raid"
            )

        )
        VideoList.add(
            LiveNews(
                "H-I7H90-57I",
                "4 hours ago",
                "https://cdn.cnn.com/cnnnext/dam/assets/210415215137-artist-leaves-free-paintings-large-169.jpg",
                "Dorchester Nursing Student Leaves Paintings Around Boston For People To Take"
            )
        )
        VideoList.add(
            LiveNews(
                "8wHScEr8Cs8",
                "19 hours ago",
                "https://cdn.cnn.com/cnnnext/dam/assets/210408164153-06-gaetz-file-2019-large-169.jpg",
                "Women detail drug use, sex and payments after late-night parties with Gaetz and others"
            )
        )
        VideoList.add(
            LiveNews(
                "ecdrgZV0unA",
                "5 days ago ",
                "https://cdn.cnn.com/cnnnext/dam/assets/210416065822-new-york-stock-exchange-0415-large-169.jpg",
                "The stock market is throwing a global party"
            )
        )
    }
    private fun buildData2() {
        VideoList2.add(
            LiveNews(
                "exMSmXqEKKo",
                "2 hours ago",
                "https://cdn.cnn.com/cnnnext/dam/assets/210415063111-01-prince-philip-tribute-london-0410-exlarge-169.jpg",
                "Millions of people around the world are expected to tune into Prince Philip's funeral service on Saturday, which will be broadcast by major television networks and streamed online."
            )
        )
        VideoList2.add(
            LiveNews(
                "H-I7H90-57I",
                "4 hours ago",
                "https://cdn.cnn.com/cnnnext/dam/assets/210413065040-djibouti-boat-capsize-exlarge-169.jpg",
                "42 migrants dead after boat from Yemen capsizes off Djibouti coast"
            )
        )
        VideoList2.add(
            LiveNews(
                "8wHScEr8Cs8",
                "19 hours ago",
                "https://cdn.cnn.com/cnnnext/dam/assets/201211201903-01-jimmy-lai-arrest-1212-medium-plus-169.jpg",
                "Hong Kong court jails Jimmy Lai and other prominent activists for 8 to 18 months over 2019 protest"
            )
        )
        VideoList2.add(
            LiveNews(
                "ecdrgZV0unA",
                "5 days ago ",
                "https://cdn.cnn.com/cnnnext/dam/assets/151223121747-tree-stock-image-getty-large-169.jpg",
                "US cities are losing 36 million trees a year. Here's why it matters and how you can stop it"
            )
        )
    }
    private fun buildData3() {
        VideoList3.add(
            LiveNews(
                "exMSmXqEKKo",
                "2 hours ago",
                "https://cdn.cnn.com/cnnnext/dam/assets/210416004057-us-coronavirus-0415-restricted-exlarge-tease.jpg",
                "Nearly half of US states reported an increase in Covid-19 cases this week. Here's what experts say can help stop another surge"
            )
        )
        VideoList3.add(
            LiveNews(
                "H-I7H90-57I",
                "4 hours ago",
                "https://cdn.cnn.com/cnnnext/dam/assets/210415111013-restricted-sinopharm-covid-19-vaccine-zimbabwe-0329-large-tease.jpg",
                "Rich nations had vaccine options after AstraZeneca and J&J faced clot reports. Others may not have that luxury"
            )
        )
        VideoList3.add(
            LiveNews(
                "8wHScEr8Cs8",
                "19 hours ago",
                "https://cdn.cnn.com/cnnnext/dam/assets/210414185138-johnson--johnson-vaccine-vial-file-large-tease.jpg",
                "What to make of the Johnson & Johnson vaccine pause? Dr. Wen, who got J&J herself, says not to worry"
            )
        )
        VideoList3.add(
            LiveNews(
                "ecdrgZV0unA",
                "5 days ago ",
                "https://cdn.cnn.com/cnnnext/dam/assets/210321005253-01-los-angeles-vaccination-0318-small-tease.jpg",
                "Is it ever OK to jump the vaccine line? We asked an ethicist"
            )
        )
    }
    private fun buildData4() {
        VideoList4.add(
            LiveNews(
                "exMSmXqEKKo",
                "2 hours ago",
                "https://cdn.cnn.com/cnnnext/dam/assets/210416041351-02-novak-djokovic-dan-evans-exlarge-tease.jpg",
                "Novak Djokovic's clay-court campaign is up and running -- but not in the way he wanted"
            )
        )
        VideoList4.add(
            LiveNews(
                "H-I7H90-57I",
                "4 hours ago",
                "https://cdn.cnn.com/cnnnext/dam/assets/210409155130-martin-braithwaite-barcelona-tease-exlarge-tease.jpg",
                "Martin Braithwaite spent time in a wheelchair as a child; now he's Lionel Messi's wingman at Barcelona"
            )
        )
        VideoList4.add(
            LiveNews(
                "8wHScEr8Cs8",
                "19 hours ago",
                "https://cdn.cnn.com/cnnnext/dam/assets/210415045738-01-cricket-racism-wisden-small-tease.jpg",
                "'By not taking a knee, cricket raised a ﬁnger': England cricket criticized for stopping kneeling in midst of fight against racism"
            )
        )
        VideoList4.add(
            LiveNews(
                "ecdrgZV0unA",
                "5 days ago ",
                "https://cdn.cnn.com/cnnnext/dam/assets/210413063125-01-rachael-blackmore-grand-national-small-tease.jpg",
                "'If you have the talent, you will be given the opportunity,' says Grand National winner Rachael Blackmore"
            )
        )
    }
    private fun buildData5() {
        VideoList5.add(
            LiveNews(
                "exMSmXqEKKo",
                "2 hours ago",
                "https://cdn.cnn.com/cnnnext/dam/assets/210330101635-01-cicadas-2021-restricted-super-tease.jpg",
                "Brood X is almost here. Billions of cicadas to emerge in eastern US"
            )
        )
        VideoList5.add(
            LiveNews(
                "H-I7H90-57I",
                "4 hours ago",
                "https://cdn.cnn.com/cnnnext/dam/assets/210313023629-eurasian-lynx-file-2012-super-tease.jpg",
                "These animals went extinct in the wild. Scientists brought them back"
            )
        )
        VideoList5.add(
            LiveNews(
                "8wHScEr8Cs8",
                "19 hours ago",
                "https://cdn.cnn.com/cnnnext/dam/assets/210414150627-05-biden-afghanistan-remarks-0414-super-tease.jpg",
                "Joe Biden is taking a calculated risk in Afghanistan"
            )
        )
        VideoList5.add(
            LiveNews(
                "ecdrgZV0unA",
                "5 days ago ",
                "https://cdn.cnn.com/cnnnext/dam/assets/210415142256-fatima-gailani-afghanistan-us-withdrawal-ctw-interview-april-15-super-tease.jpg",
                "Afghan negotiator: I'm worried about withdrawal without peace"
            )
        )
    }
}