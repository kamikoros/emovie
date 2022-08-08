package com.example.emovie.data.model

import com.google.gson.annotations.SerializedName

data class GenreModels (
    @SerializedName("genres")
    val genres: List<GenreModel>
    )