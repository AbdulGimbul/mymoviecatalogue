package com.example.abdl.mymoviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.abdl.mymoviecatalogue.data.source.FilmRepository
import com.example.abdl.mymoviecatalogue.di.Injection
import com.example.abdl.mymoviecatalogue.ui.detail.DetailFilmCatalogueViewModel
import com.example.abdl.mymoviecatalogue.ui.favorites.movies.MoviesFavoriteViewModel
import com.example.abdl.mymoviecatalogue.ui.favorites.tvshow.TvShowFavoriteViewModel
import com.example.abdl.mymoviecatalogue.ui.movies.MoviesViewModel
import com.example.abdl.mymoviecatalogue.ui.tvshow.TvShowViewModel

class ViewModelFactory(private val mFilmRepository: FilmRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(DetailFilmCatalogueViewModel::class.java) -> {
                return DetailFilmCatalogueViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                return MoviesViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(MoviesFavoriteViewModel::class.java) -> {
                return MoviesFavoriteViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(TvShowFavoriteViewModel::class.java) -> {
                return TvShowFavoriteViewModel(mFilmRepository) as T
            }
            else -> throw Throwable("Unknown viewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }
}