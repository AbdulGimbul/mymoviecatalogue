package com.example.abdl.mymoviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity

@Dao
interface MovieCatalogueDao {
    @Query("SELECT * FROM moviesentities")
    fun getMovies(): DataSource.Factory<Int, MoviesEntity>

    @Query("SELECT * FROM tvshowentities")
    fun getTvshow(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM moviesentities WHERE favorited = 1")
    fun getFavoritedMovies(): DataSource.Factory<Int, MoviesEntity>

    @Query("SELECT * FROM tvshowentities WHERE favorited = 1")
    fun getFavoritedTvshow(): DataSource.Factory<Int, TvShowEntity>

    @Transaction
    @Query("SELECT * FROM moviesentities WHERE movieId = :movieId")
    fun getMoviesById(movieId: String): LiveData<MoviesEntity>

    @Transaction
    @Query("SELECT * FROM tvshowentities WHERE tvShowId = :tvShowId")
    fun getTvShowById(tvShowId: String): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MoviesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvshow(tvshow: List<TvShowEntity>)
    
    @Update
    fun updateMovies(movies: MoviesEntity)

    @Update
    fun updateTvshow(tvshow: TvShowEntity)

}