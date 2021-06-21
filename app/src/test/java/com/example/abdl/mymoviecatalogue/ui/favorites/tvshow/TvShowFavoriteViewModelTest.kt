package com.example.abdl.mymoviecatalogue.ui.favorites.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.abdl.mymoviecatalogue.data.source.FilmRepository
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity
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
class TvShowFavoriteViewModelTest {
    private lateinit var viewModel: TvShowFavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = TvShowFavoriteViewModel(filmRepository)
    }

    @Test
    fun getTvShowFavorited() {
        val dummyTvShow = pagedList
        `when`(dummyTvShow.size).thenReturn(10)
        val tvshow = MutableLiveData<PagedList<TvShowEntity>>()
        tvshow.value = dummyTvShow

        `when`(filmRepository.getFavoritedTvshow()).thenReturn(tvshow)
        val tvshowEntities = viewModel.getTvShowFavorited().value
        verify(filmRepository).getFavoritedTvshow()
        assertNotNull(tvshowEntities)
        assertEquals(10, tvshowEntities?.size)

        viewModel.getTvShowFavorited().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}