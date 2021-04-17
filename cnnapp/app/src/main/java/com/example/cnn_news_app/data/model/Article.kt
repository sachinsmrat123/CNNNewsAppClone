package com.example.cnn_news_app.data.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
@Entity(tableName = "articlesTable")
data class Article(
        @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
        var saved:Int = 0,
        @SerializedName("author")
    val author: String?,
        @SerializedName("content")
    val content: String?,
        @SerializedName("description")
    val description: String?,
        @SerializedName("publishedAt")
    val publishedAt: String?,
        @SerializedName("source")
    val source:  @RawValue Source?,
        @SerializedName("title")
    val title: String?,
        @SerializedName("url")
    val url: String?,
        @SerializedName("urlToImage")
    val urlToImage: String?
):Parcelable