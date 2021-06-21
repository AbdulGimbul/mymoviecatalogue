package com.example.abdl.mymoviecatalogue.ui.favorites.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.abdl.mymoviecatalogue.data.source.FilmRepository
import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity

class MoviesFavoriteViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getMoviesFavorited(): LiveData<PagedList<MoviesEntity>> {
        return filmRepository.getFavoritedMovies()
    }
}