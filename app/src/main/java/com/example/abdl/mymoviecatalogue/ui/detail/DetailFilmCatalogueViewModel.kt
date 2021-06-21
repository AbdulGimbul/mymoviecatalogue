package com.example.abdl.mymoviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.abdl.mymoviecatalogue.data.source.FilmRepository
import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity
import com.example.abdl.mymoviecatalogue.vo.Resource

class DetailFilmCatalogueViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    val movieId = MutableLiveData<String>()
    val tvshowId = MutableLiveData<String>()

    fun setSelectedMovies(movieId: String) {
        this.movieId.value = movieId
    }

    fun setSelectedTvShow(tvshowId: String) {
        this.tvshowId.value = tvshowId
    }

    var moviesData: LiveData<Resource<MoviesEntity>> =
        Transformations.switchMap(movieId) { mMovieId ->
            filmRepository.getMoviesById(mMovieId)
        }
    var tvshowData: LiveData<Resource<TvShowEntity>> =
        Transformations.switchMap(tvshowId) { mTvShowId ->
            filmRepository.getTvShowById(mTvShowId)
        }

    fun setFavoriteMovies() {
        val movieResource = moviesData.value

        if (movieResource != null) {
            val moviesWithId = movieResource.data

            if (moviesWithId != null) {
                val newState = !moviesWithId.favorited
                filmRepository.setFavoritedMovies(moviesWithId, newState)
            }
        }
    }

    fun setFavoriteTvShow() {
        val tvshowResource = tvshowData.value

        if (tvshowResource != null) {
            val tvshowWithId = tvshowResource.data

            if (tvshowWithId != null) {
                val newState = !tvshowWithId.favorited
                filmRepository.setFavoritedTvshow(tvshowWithId, newState)
            }
        }
    }
}