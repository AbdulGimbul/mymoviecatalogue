package com.example.abdl.mymoviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.abdl.mymoviecatalogue.data.source.FilmRepository
import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity
import com.example.abdl.mymoviecatalogue.utils.DataDummy

class DetailFilmCatalogueViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    private lateinit var moviesId: String
    private lateinit var tvShowId: String

    fun setSelectedMovies(moviesId: String){
        this.moviesId = moviesId
    }
    fun setSelectedTvShow(tvshowId: String){
        this.tvShowId = tvshowId
    }

    fun getMovies(): LiveData<MoviesEntity> = filmRepository.getDetailMovies(moviesId)

    fun getTvShow(): LiveData<TvShowEntity> = filmRepository.getDetailTvShow(tvShowId)
}