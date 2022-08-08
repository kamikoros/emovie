package com.example.emovie.domain

import com.example.emovie.data.MovieRepository
import com.example.emovie.data.model.*
import com.example.emovie.domain.modulo.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetListMovieTest{

    @RelaxedMockK
    private lateinit var movieRepository: MovieRepository

    lateinit var getListMovie: GetListMovie

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getListMovie = GetListMovie(movieRepository)
    }

    @Test
    fun `when the api doesnt return anything then get values from database`() = runBlocking {
        //Given
        coEvery { movieRepository.getAllMovie(TypeCategory.upComing) } returns emptyList()
        //When
        getListMovie(TypeCategory.upComing)

        //Then
        coVerify(exactly = 1) { movieRepository.getMovieFromBasedato(TypeCategory.upComing) }
    }

    @Test
    fun `when the api return something then get values from api`() = runBlocking {
        //Given
        val myList = listOf(Movie(
            false,
            "",
            100,
            "es",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "")
        )
        coEvery { movieRepository.getAllMovie(TypeCategory.upComing) } returns myList

        //When
        val response = getListMovie(TypeCategory.upComing)

        //Then
        coVerify(exactly = 1) { movieRepository.clearMovies(TypeCategory.upComing) }
        coVerify(exactly = 1) { movieRepository.insertMovie(any(),TypeCategory.upComing) }
        coVerify(exactly = 0) { movieRepository.getMovieFromBasedato(TypeCategory.upComing) }
        assert(response == myList)
    }





}