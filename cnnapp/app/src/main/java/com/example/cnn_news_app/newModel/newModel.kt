package com.example.cnn_news_app.newModel


import com.google.gson.annotations.SerializedName

data class newModel(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("pagination")
    val pagination: Pagination
)