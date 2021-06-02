package com.example.abdl.mymoviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.abdl.mymoviecatalogue.data.source.FilmRepository
import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity
import com.example.abdl.mymoviecatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailFilmCatalogueViewModelTest {
    private lateinit var viewModelDetail: DetailFilmCatalogueViewModel
    private val dummyMovies = DataDummy.generateDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val moviesId = dummyMovies.moviesId
    private val tvshowId = dummyTvShow.TvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observerMovies: Observer<MoviesEntity>

    @Mock
    private lateinit var observerTvShow: Observer<TvShowEntity>

    @Before
    fun setUp(){
        viewModelDetail = DetailFilmCatalogueViewModel(filmRepository)
        viewModelDetail.setSelectedMovies(moviesId)
        viewModelDetail.setSelectedTvShow(tvshowId)
    }

    @Test
    fun getMovies() {
        val movie = MutableLiveData<MoviesEntity>()
        movie.value = dummyMovies

        `when`(filmRepository.getDetailMovies(moviesId)).thenReturn(movie)
        val movieEntity = viewModelDetail.getMovies().value as MoviesEntity
        verify(filmRepository).getDetailMovies(moviesId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovies.moviesId, movieEntity.moviesId)
        assertEquals(dummyMovies.director, movieEntity.director)
        assertEquals(dummyMovies.title, movieEntity.title)
        assertEquals(dummyMovies.genre, movieEntity.genre)
        assertEquals(dummyMovies.overview, movieEntity.overview)
        assertEquals(dummyMovies.image, movieEntity.image)

        viewModelDetail.getMovies().observeForever(observerMovies)
        verify(observerMovies).onChanged(dummyMovies)
    }

    @Test
    fun getTvShow() {
        val tvshow = MutableLiveData<TvShowEntity>()
        tvshow.value = dummyTvShow

        `when`(filmRepository.getDetailTvShow(tvshowId)).thenReturn(tvshow)
        val tvShowEntity = viewModelDetail.getTvShow().value as TvShowEntity
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.TvShowId, tvShowEntity.TvShowId)
        assertEquals(dummyTvShow.creator, tvShowEntity.creator)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.year, tvShowEntity.year)
        assertEquals(dummyTvShow.overview, tvShowEntity.overview)
        assertEquals(dummyTvShow.image, tvShowEntity.image)

        viewModelDetail.getTvShow().observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvShow)
    }
}