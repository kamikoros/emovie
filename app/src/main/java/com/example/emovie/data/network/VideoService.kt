package com.example.emovie.data.network

import com.example.emovie.core.network.Config
import com.example.emovie.data.model.VideoModel
import com.example.emovie.domain.modulo.Genre
import com.example.emovie.domain.modulo.Video
import com.example.emovie.domain.modulo.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class VideoService @Inject constructor(private val api:MovieApiClient) {

    suspend fun getVideo(id:Int): List<Video> {
        return try {
            withContext(Dispatchers.IO) {
                val response = api.getVideo(id,Config.apiKey)
                response.body()?.results?.map {
                    it.toDomain()
                }?: arrayListOf()
            }
        }catch (e: IOException){
            return arrayListOf()
        }
    }



}