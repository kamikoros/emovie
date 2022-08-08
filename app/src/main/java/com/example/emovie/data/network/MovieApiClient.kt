package com.example.emovie.data.network

import com.example.emovie.data.model.MovieModels
import com.example.emovie.data.model.GenreModels
import com.example.emovie.data.model.VideoModels
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiClient {
    @GET("movie/upcoming?language=es")
    suspend fun getAllUpComing(@Query("api_key") key: String): Response<MovieModels>

    @GET("movie/top_rated?language=es")
    suspend fun getAllTopRated(@Query("api_key") key: String): Response<MovieModels>

    @GET("genre/movie/list?language=es")
    suspend fun getGenre(@Query("api_key") api_key:String): Response<GenreModels?>

    @GET("movie/{movie_id}/videos?language=es")
    suspend fun getVideo(@Path("movie_id") id: Int, @Query("api_key") api_key:String): Response<VideoModels?>


}