package com.example.emovie.data.basedato.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.emovie.data.model.TypeCategory
import com.example.emovie.domain.modulo.Movie
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
    data class  MovieEntity(
        @ColumnInfo(name = "adult")
        val adult: Boolean,
        @ColumnInfo(name="backdrop_path")
        val backdrop_path: String,
        @PrimaryKey
        @ColumnInfo(name="id")
        val id: Int,
        @ColumnInfo(name="original_language")
        val original_language: String,
        @ColumnInfo(name="original_title")
        val original_title: String,
        @ColumnInfo(name="overview")
        val overview:String,
        @ColumnInfo(name="popularity")
        val popularity: String,
        @ColumnInfo(name="poster_path")
        val poster_path: String,
        @ColumnInfo(name="release_date")
        val release_date: String,
        @ColumnInfo(name="title")
        val title: String,
        @ColumnInfo(name="type")
        val type: String,
        @ColumnInfo(name ="genre_ids")
        val genre_ids: String,
        @ColumnInfo(name ="vote_average")
        val vote_average: String,
    )

    fun Movie.toDataBase(type:TypeCategory)= MovieEntity(
        id = id,
        adult = adult,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        release_date = release_date,
        title = title,
        backdrop_path = backdrop_path,
        type = type.name,
        genre_ids =genre_ids,
        vote_average = vote_average

    )



