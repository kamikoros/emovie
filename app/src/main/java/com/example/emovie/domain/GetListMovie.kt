package com.example.emovie.domain

import com.example.emovie.data.model.TypeCategory
import com.example.emovie.data.MovieRepository
import com.example.emovie.domain.modulo.Movie
import javax.inject.Inject

class GetListMovie @Inject constructor(private val repository:MovieRepository){

    suspend operator fun invoke(type:TypeCategory): List<Movie>{
        val result = repository.getAllMovie(type)
        return if(result.isNotEmpty()){
            repository.clearMovies(type)
            repository.insertMovie(result,type)
            result
        }else {
            repository.getMovieFromBasedato(type)
        }

    }
}