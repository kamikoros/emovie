package com.example.emovie.domain

import com.example.emovie.data.VideoRepository
import com.example.emovie.domain.modulo.Video
import javax.inject.Inject

class GetListVideo @Inject constructor(private val repository: VideoRepository) {

    suspend operator fun invoke(id: Int): List<Video> {
        return repository.getVideo(id)
    }
}