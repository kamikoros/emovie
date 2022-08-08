package com.example.emovie.core.basedato

import android.content.Context
import androidx.room.Room
import com.example.emovie.data.basedato.MovieDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuloRoom {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        MovieDataBase::class.java,
        "db_movie"
    ).build()

    @Singleton
    @Provides
    fun provideMovieDao(db: MovieDataBase) = db.getMovieDao()

    @Singleton
    @Provides
    fun provideGenreDao(db: MovieDataBase) = db.getGenreDao()

}