package com.example.emovie.domain

import com.example.emovie.data.MovieRepository
import com.example.emovie.data.VideoRepository
import com.example.emovie.data.model.TypeCategory
import com.example.emovie.domain.GetListMovie
import com.example.emovie.domain.GetListVideo
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


internal class GetListVideoTest{

    @RelaxedMockK
    private lateinit var videoRepository: VideoRepository

    lateinit var getListVideo: GetListVideo

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getListVideo = GetListVideo(videoRepository)
    }

    @Test
    fun `when the api doesnt return anything`() = runBlocking {

        //Given
        coEvery { videoRepository.getVideo(10) } returns emptyList()

        //When
        getListVideo(10)

        //Then
        coVerify(exactly = 1) { videoRepository.getVideo(any())}


    }



}