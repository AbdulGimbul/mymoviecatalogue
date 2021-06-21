package com.example.abdl.mymoviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.abdl.mymoviecatalogue.data.source.FilmRepository
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity
import com.example.abdl.mymoviecatalogue.vo.Resource

class TvShowViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> = filmRepository.getAllTvShows()
}