package com.example.cnn_news_app.liveTv.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cnn_news_app.model.LiveNews
import kotlinx.android.synthetic.main.item_live_news.view.*

class LiveNewsholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun set(liveNews: LiveNews){
        itemView.apply {
            Glide.with(ivImage).load(liveNews.videoImage).into(ivImage)
            tvTitle.text = liveNews.videoTitle
            tvTime.text = liveNews.VideoTime
//            ivPlayButton.setOnClickListener {
//                findNavController().navigate(
//                   // R.id.action_youtubePlayerSupportFragments_to_recommendedNewsFragment,
//                )
//            }
        }
    }
}