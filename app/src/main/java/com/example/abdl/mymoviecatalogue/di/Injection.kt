package com.example.abdl.mymoviecatalogue.di

import android.content.Context
import com.example.abdl.mymoviecatalogue.data.source.FilmRepository
import com.example.abdl.mymoviecatalogue.data.source.local.LocalDataSource
import com.example.abdl.mymoviecatalogue.data.source.local.room.MovieCatalogueDatabase
import com.example.abdl.mymoviecatalogue.data.source.remote.RemoteDataSource
import com.example.abdl.mymoviecatalogue.utils.AppExecutors
import com.example.abdl.mymoviecatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context) : FilmRepository{

        val database = MovieCatalogueDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.movieCatalogueDao())
        val appExecutors = AppExecutors()

        return FilmRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}