package com.example.emovie.domain

import com.example.emovie.data.MovieRepository
import com.example.emovie.domain.modulo.Movie
import javax.inject.Inject

class GetDetailMovie @Inject constructor(private val repository: MovieRepository){
    suspend operator fun invoke(id:Int): Movie = repository.getMovieDetalleFromBaseDato(id)
}