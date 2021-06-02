package com.example.abdl.mymoviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity

interface FilmDataSource {
    fun getAllMovies(): LiveData<List<MoviesEntity>>
    fun getAllTvShows(): LiveData<List<TvShowEntity>>

    fun getDetailMovies(movieId: String) : LiveData<MoviesEntity>
    fun getDetailTvShow(tvshowId: String) : LiveData<TvShowEntity>
}