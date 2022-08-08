package com.example.emovie.data

import com.example.emovie.data.basedato.dao.GenreDao
import com.example.emovie.data.basedato.entities.toDataBase
import com.example.emovie.data.network.GenreService
import com.example.emovie.domain.modulo.Genre
import com.example.emovie.domain.modulo.toDomain
import javax.inject.Inject

    class GenreRepository @Inject constructor(private val api: GenreService, private val db: GenreDao){


    suspend fun getGenre(): List<Genre>{
        return api.getGenre()
    }


        suspend fun insertGenre(genre: List<Genre>){
            db.insertAll(genre.map { it.toDataBase() })
        }

        suspend fun clearGenre(){
            db.deleteAll()
        }

}