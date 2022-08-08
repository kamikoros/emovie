package com.example.emovie.data.basedato

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.emovie.data.basedato.dao.GenreDao
import com.example.emovie.data.basedato.dao.MovieDao
import com.example.emovie.data.basedato.entities.GenreEntity
import com.example.emovie.data.basedato.entities.MovieEntity


@Database(
    entities = [
        MovieEntity::class,
        GenreEntity::class
               ],
    version = 1
)
abstract class MovieDataBase :RoomDatabase() {

    abstract fun getMovieDao(): MovieDao

    abstract fun getGenreDao():GenreDao
}