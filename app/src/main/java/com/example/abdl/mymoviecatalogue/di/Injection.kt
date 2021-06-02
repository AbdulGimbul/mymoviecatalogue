package com.example.abdl.mymoviecatalogue.di

import android.content.Context
import com.example.abdl.mymoviecatalogue.data.source.FilmRepository
import com.example.abdl.mymoviecatalogue.data.source.remote.RemoteDataSource
import com.example.abdl.mymoviecatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context) : FilmRepository{
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return FilmRepository.getInstance(remoteDataSource)
    }
}