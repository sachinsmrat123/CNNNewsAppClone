package com.example.cnn_news_app.newModel


import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("count")
    val count: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("total")
    val total: Int
)