package com.example.abdl.mymoviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.abdl.mymoviecatalogue.data.source.local.LocalDataSource
import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity
import com.example.abdl.mymoviecatalogue.data.source.remote.RemoteDataSource
import com.example.abdl.mymoviecatalogue.utils.*
import com.example.abdl.mymoviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class FilmRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val filmRepository = FakeFilmRepository(remote, local, appExecutors)

    private val movieResponse = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponse[0].movieId
    private val tvShowResponse = DataDummy.generateRemoteDummyTvshow()
    private val tvshowId = tvShowResponse[0].TvShowId

    @Test
    fun getAllMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        filmRepository.getAllMovies()

        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShows() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvshow()).thenReturn(dataSourceFactory)
        filmRepository.getAllTvShows()

        val tvShowEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getAllTvshow()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getMoviesById() {
        val dataSourceFactory = MutableLiveData<MoviesEntity>()
        dataSourceFactory.value =
            DetailDummy.getDetailMovie(DataDummy.generateDummyMovies()[0].movieId)
        `when`(movieId?.let { local.getMovies(movieId) }).thenReturn(dataSourceFactory)

        val movieDetailSource = LiveDataTestUtil.getValue(filmRepository.getMoviesById(movieId))
        verify(local).getMovies(movieId)
        assertNotNull(movieDetailSource.data)
        assertNotNull(movieDetailSource.data?.title)
    }

    @Test
    fun getTvShowById() {
        val dataSourceFactory = MutableLiveData<TvShowEntity>()
        dataSourceFactory.value =
            DetailDummy.getDetailTvShow(DataDummy.generateDummyTvShows()[0].tvShowId)
        `when`(tvshowId?.let { local.getTvShow(tvshowId) }).thenReturn(dataSourceFactory)

        val tvshowDetailSource = LiveDataTestUtil.getValue(filmRepository.getTvShowById(tvshowId))
        verify(local).getTvShow(tvshowId)
        assertNotNull(tvshowDetailSource.data)
        assertNotNull(tvshowDetailSource.data?.title)
    }

    @Test
    fun getFavoritedMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(local.getFavoritedMovies()).thenReturn(dataSourceFactory)
        filmRepository.getFavoritedMovies()

        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavoritedMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoritedTvShow() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoritedTvshow()).thenReturn(dataSourceFactory)
        filmRepository.getFavoritedTvshow()

        val tvshowEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getFavoritedTvshow()
        assertNotNull(tvshowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvshowEntities.data?.size?.toLong())
    }
}