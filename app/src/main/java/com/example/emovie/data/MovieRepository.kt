package com.example.emovie.data

import android.util.Log
import com.example.emovie.data.basedato.dao.GenreDao
import com.example.emovie.data.basedato.dao.MovieDao
import com.example.emovie.data.basedato.entities.toDataBase
import com.example.emovie.data.model.*
import com.example.emovie.data.network.MovieService
import com.example.emovie.domain.modulo.Movie
import com.example.emovie.domain.modulo.toDomain
import javax.inject.Inject

class MovieRepository  @Inject constructor( private val api:MovieService,private val movieDao: MovieDao,private val genreDao: GenreDao){

    suspend fun getAllMovie(typeCategory: TypeCategory): List<Movie>{
        return when(typeCategory){
            TypeCategory.upComing -> api.get()
            TypeCategory.topRated -> api.getTopReted()
        }
    }


    suspend fun getMovieFromBasedato(type: TypeCategory):List<Movie>{
        return movieDao.getList(type.name).map { it.toDomain() }
    }

    suspend fun insertMovie(movies:List<Movie>,type: TypeCategory){
        movieDao.insertAll(movies.map { it.toDataBase(type) })
    }

    suspend fun clearMovies(type: TypeCategory){
        movieDao.deleteAll(type.name)
    }

    suspend fun getMovieDetalleFromBaseDato(id: Int) :Movie{
       val result = movieDao.getId(id).toDomain()
       val listId = result.genre_ids.replace(" ","").split(",").map { it.toInt() }
        val genres = genreDao.getListId(listId).map { it.toDomain() }
        result.genres =genres
        return result
    }



}