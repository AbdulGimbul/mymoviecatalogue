package com.example.abdl.mymoviecatalogue.ui.favorites.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.abdl.mymoviecatalogue.data.source.FilmRepository
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity

class TvShowFavoriteViewModel(private val filmRepository: FilmRepository): ViewModel() {
    fun getTvShowFavorited(): LiveData<PagedList<TvShowEntity>>{
        return filmRepository.getFavoritedTvshow()
    }
}