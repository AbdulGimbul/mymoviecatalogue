package com.example.abdl.mymoviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity
import com.example.abdl.mymoviecatalogue.data.source.local.room.MovieCatalogueDao

class LocalDataSource private constructor(private val mMovieCatalogueDao: MovieCatalogueDao) {

    fun getAllMovies(): DataSource.Factory<Int, MoviesEntity> = mMovieCatalogueDao.getMovies()
    fun getAllTvshow(): DataSource.Factory<Int, TvShowEntity> = mMovieCatalogueDao.getTvshow()

    fun getFavoritedMovies(): DataSource.Factory<Int, MoviesEntity> =
        mMovieCatalogueDao.getFavoritedMovies()

    fun getFavoritedTvshow(): DataSource.Factory<Int, TvShowEntity> =
        mMovieCatalogueDao.getFavoritedTvshow()

    fun getMovies(movieId: String): LiveData<MoviesEntity> =
        mMovieCatalogueDao.getMoviesById(movieId)

    fun getTvShow(tvshowId: String): LiveData<TvShowEntity> =
        mMovieCatalogueDao.getTvShowById(tvshowId)

    fun insertMovies(movies: List<MoviesEntity>) = mMovieCatalogueDao.insertMovies(movies)
    fun insertTvshow(tvshow: List<TvShowEntity>) = mMovieCatalogueDao.insertTvshow(tvshow)

    fun setMoviesFavorite(movies: MoviesEntity, newState: Boolean) {
        movies.favorited = newState
        mMovieCatalogueDao.updateMovies(movies)
    }

    fun setTvshowFavorite(tvshow: TvShowEntity, newState: Boolean) {
        tvshow.favorited = newState
        mMovieCatalogueDao.updateTvshow(tvshow)
    }

    companion object {
        private val INSTANCE: LocalDataSource? = null

        fun getInstance(movieCatalogueDao: MovieCatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieCatalogueDao)
    }
}