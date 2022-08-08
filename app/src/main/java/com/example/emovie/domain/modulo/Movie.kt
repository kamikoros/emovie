package com.example.emovie.domain.modulo
import com.example.emovie.data.basedato.entities.MovieEntity
import com.example.emovie.data.model.MovieModel

data class Movie(
    val adult: Boolean,
    val backdrop_path: String,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview:String,
    val popularity: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val genre_ids:String,
    val vote_average:String,
    var genres:List<Genre> = arrayListOf()
)

    fun MovieModel.toDomain() = Movie(adult, backdrop_path,id, original_language, original_title, overview,popularity, poster_path, release_date, title, genre_ids.joinToString(),vote_average)
    fun MovieEntity.toDomain() = Movie(adult, backdrop_path,id, original_language, original_title, overview,popularity, poster_path, release_date, title, genre_ids,vote_average)



