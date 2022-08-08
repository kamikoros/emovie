package com.example.emovie.data.network

import com.example.emovie.core.network.Config
import com.example.emovie.data.model.*
import com.example.emovie.domain.modulo.Genre
import com.example.emovie.domain.modulo.Movie
import com.example.emovie.domain.modulo.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class MovieService @Inject constructor(private val api:MovieApiClient) {
    suspend fun get(): List<Movie> {
        return try {
            withContext(Dispatchers.Default) {
                val response = api.getAllUpComing(Config.apiKey)
                response.body()?.results?.map {
                    it.toDomain()
                } ?: arrayListOf()
            }

        }catch (e: IOException){
            arrayListOf()
        }
    }

    suspend fun getTopReted(): List<Movie> {
        return try {
            withContext(Dispatchers.IO) {
                val response = api.getAllTopRated(Config.apiKey)
                response.body()?.results?.map {
                    it.toDomain()
                } ?: arrayListOf()
            }
        }catch (e:IOException){
            return arrayListOf()
        }
    }
}