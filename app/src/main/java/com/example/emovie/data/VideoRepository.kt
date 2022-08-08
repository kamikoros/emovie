package com.example.emovie.data

import com.example.emovie.data.model.VideoModel
import com.example.emovie.data.network.VideoService
import com.example.emovie.domain.modulo.Video
import javax.inject.Inject
class VideoRepository  @Inject constructor(private val api: VideoService) {

    suspend fun getVideo(id:Int): List<Video> {
        return api.getVideo(id)
    }
}