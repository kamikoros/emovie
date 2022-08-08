package com.example.emovie.data.model

import com.google.gson.annotations.SerializedName

data class VideoModel (
    @SerializedName("name")
    val name: String,
    @SerializedName("key")
    val key: String,
    @SerializedName("site")
    val site: String,
    @SerializedName("published_at")
    val published_at: String
    )