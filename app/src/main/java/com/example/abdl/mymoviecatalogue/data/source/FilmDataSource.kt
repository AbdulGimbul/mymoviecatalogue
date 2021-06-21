package com.example.abdl.mymoviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity
import com.example.abdl.mymoviecatalogue.vo.Resource

interface FilmDataSource {
    fun getAllMovies(): LiveData<Resource<PagedList<MoviesEntity>>>
    fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getMoviesById(movieId: String): LiveData<Resource<MoviesEntity>>
    fun getTvShowById(tvshowId: String): LiveData<Resource<TvShowEntity>>

    fun getFavoritedMovies(): LiveData<PagedList<MoviesEntity>>
    fun getFavoritedTvshow(): LiveData<PagedList<TvShowEntity>>

    fun setFavoritedMovies(movies: MoviesEntity, state: Boolean)
    fun setFavoritedTvshow(tvshow: TvShowEntity, state: Boolean)

}