package com.example.emovie.data.network

import com.example.emovie.core.network.Config
import com.example.emovie.domain.modulo.Genre
import com.example.emovie.domain.modulo.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class GenreService @Inject constructor(private val api:MovieApiClient) {

    suspend fun getGenre(): List<Genre> {
        return try {
            withContext(Dispatchers.IO) {
                val response = api.getGenre(Config.apiKey)
                response.body()?.genres?.map {
                    it.toDomain()
                } ?: arrayListOf()
            }
        }catch (e: IOException){
            return arrayListOf()
        }
    }



}