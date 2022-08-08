package com.example.emovie.data.model

import com.google.gson.annotations.SerializedName

data class VideoModels (
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<VideoModel>,
)