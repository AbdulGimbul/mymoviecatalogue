package com.example.abdl.mymoviecatalogue.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.abdl.mymoviecatalogue.data.source.FilmRepository
import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity
import com.example.abdl.mymoviecatalogue.vo.Resource

class MoviesViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getMovies(): LiveData<Resource<PagedList<MoviesEntity>>> = filmRepository.getAllMovies()
}