package com.example.emovie.domain

import com.example.emovie.data.GenreRepository
import com.example.emovie.data.MovieRepository
import com.example.emovie.data.model.TypeCategory
import com.example.emovie.domain.modulo.Genre
import com.example.emovie.domain.modulo.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetDataGenreTest{


    @RelaxedMockK
    private lateinit var genreRepository: GenreRepository

    lateinit var getDataGenre: GetDataGenre

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getDataGenre = GetDataGenre(genreRepository)
    }

    @Test
    fun `when the api return something then get values from api`() = runBlocking {
        //Given
        val myList = listOf(
            Genre(
            10,
            "comedia")
        )

        coEvery { genreRepository.getGenre() } returns myList

        //When
        getDataGenre()

        //Then
        coVerify(exactly = 1) { genreRepository.clearGenre() }
        coVerify(exactly = 1) { genreRepository.insertGenre(any()) }

    }


}