package com.example.emovie.data.model

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdrop_path: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_language")
    val original_language: String,
    @SerializedName("original_title")
    val original_title: String,
    @SerializedName("overview")
    val overview:String,
    @SerializedName("popularity")
    val popularity: String,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("genre_ids")
    val genre_ids: List<Int>,
    @SerializedName("vote_average")
    val vote_average: String,





    )