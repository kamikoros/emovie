package com.example.emovie.domain.modulo

import com.example.emovie.data.model.VideoModel

data class Video (
val name: String,
val key: String,
val site: String,
val published_at: String
)

fun VideoModel.toDomain() = Video(name,key,site,published_at)
