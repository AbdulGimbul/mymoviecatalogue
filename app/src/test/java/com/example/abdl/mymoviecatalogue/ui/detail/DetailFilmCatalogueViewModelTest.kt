package com.example.abdl.mymoviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.abdl.mymoviecatalogue.data.source.FilmRepository
import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity
import com.example.abdl.mymoviecatalogue.utils.DataDummy
import com.example.abdl.mymoviecatalogue.utils.DetailDummy
import com.example.abdl.mymoviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailFilmCatalogueViewModelTest {
    private lateinit var viewModelDetail: DetailFilmCatalogueViewModel
    private val generateDummyMovies = DataDummy.generateDummyMovies()[0]
    private val generateDummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val moviesId = generateDummyMovies.movieId
    private val tvshowId = generateDummyTvShow.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private var filmRepository = mock(FilmRepository::class.java)

    @Mock
    private lateinit var observerMovies: Observer<Resource<MoviesEntity>>

    @Mock
    private lateinit var observerTvShow: Observer<Resource<TvShowEntity>>

    @Before
    fun setUp() {
        viewModelDetail = DetailFilmCatalogueViewModel(filmRepository)
    }

    @Test
    fun detailMoviesData() {
        moviesId?.let { viewModelDetail.setSelectedMovies(it) }

        val dummyMovies = Resource.success(DetailDummy.getDetailMovie(moviesId))
        val movies = MutableLiveData<Resource<MoviesEntity>>()
        movies.value = dummyMovies

        `when`(moviesId?.let { filmRepository.getMoviesById(it) }).thenReturn(movies)
        viewModelDetail.moviesData.observeForever(observerMovies)
        verify(filmRepository).getMoviesById(moviesId)
        assertNotNull(viewModelDetail.moviesData)
        assertEquals(viewModelDetail.moviesData?.value?.data?.movieId, generateDummyMovies.movieId)
    }

    @Test
    fun detailTvshowData() {
        tvshowId?.let { viewModelDetail.setSelectedTvShow(it) }

        val dummyTvShow = Resource.success(DetailDummy.getDetailTvShow(tvshowId))
        val tvshow = MutableLiveData<Resource<TvShowEntity>>()
        tvshow.value = dummyTvShow

        `when`(tvshowId?.let { filmRepository.getTvShowById(tvshowId) }).thenReturn(tvshow)
        viewModelDetail.tvshowData.observeForever(observerTvShow)
        verify(filmRepository).getTvShowById(tvshowId)
        assertNotNull(viewModelDetail.tvshowData)
        assertEquals(
            viewModelDetail.tvshowData?.value?.data?.tvShowId,
            generateDummyTvShow.tvShowId
        )
    }
}