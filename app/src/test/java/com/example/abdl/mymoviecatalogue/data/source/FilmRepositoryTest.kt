package com.example.abdl.mymoviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.abdl.mymoviecatalogue.data.source.remote.RemoteDataSource
import com.example.abdl.mymoviecatalogue.utils.DataDummy
import com.example.abdl.mymoviecatalogue.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class FilmRepositoryTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val filmRepository = FakeFilmRepository(remote)

    private val movieResponse = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponse[0].movieId
    private val tvShowResponse = DataDummy.generateRemoteDummyTvshow()
    private val tvshowId = tvShowResponse[0].TvShowId

    @Test
    fun getAllMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponse)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(filmRepository.getAllMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvShowResponse)
            null
        }.`when`(remote).getAllTvShows(any())
        val tvShowEntities = LiveDataTestUtil.getValue(filmRepository.getAllTvShows())
        verify(remote).getAllTvShows(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getDetailMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponse)
            null
        }.`when`(remote).getAllMovies(any())

        val movieEntities = LiveDataTestUtil.getValue(filmRepository.getDetailMovies(movieId))
        verify(remote).getAllMovies(any())

        assertNotNull(movieEntities)
        assertNotNull(movieEntities.title)
        assertEquals(movieResponse[0].title, movieEntities.title)
    }

    @Test
    fun getDetailTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvShowResponse)
            null
        }.`when`(remote).getAllTvShows(any())

        val tvshowEntities = LiveDataTestUtil.getValue(filmRepository.getDetailTvShow(tvshowId))

        verify(remote).getAllTvShows(any())

        assertNotNull(tvshowEntities)
        assertNotNull(tvshowEntities.title)
        assertEquals(tvShowResponse[0].title, tvshowEntities.title)

    }
}