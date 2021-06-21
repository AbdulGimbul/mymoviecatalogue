package com.example.abdl.mymoviecatalogue.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity

@Database(entities = [MoviesEntity::class, TvShowEntity::class],
    version = 1,
    exportSchema = false)
abstract class MovieCatalogueDatabase : RoomDatabase() {
    abstract fun movieCatalogueDao(): MovieCatalogueDao

    companion object{
        @Volatile
        private var INSTANCE: MovieCatalogueDatabase? = null

        fun getInstance(context: Context): MovieCatalogueDatabase =
            INSTANCE ?: synchronized(this){
                Room.databaseBuilder(
                    context.applicationContext,
                    MovieCatalogueDatabase::class.java,
                    "MovieCatalogue.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}