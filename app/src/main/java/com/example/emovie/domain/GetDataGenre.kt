package com.example.emovie.domain

import com.example.emovie.data.GenreRepository
import com.example.emovie.domain.modulo.Genre
import javax.inject.Inject

class GetDataGenre @Inject constructor(private val repository: GenreRepository){

    suspend operator fun invoke(){
        val result = repository.getGenre()
         if(result.isNotEmpty()){
            repository.clearGenre()
            repository.insertGenre(result)
        }
    }
}