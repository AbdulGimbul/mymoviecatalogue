package com.example.abdl.mymoviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "moviesentities")
data class MoviesEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "director")
    var director: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "favorited")
    var favorited: Boolean = false,

    @ColumnInfo(name = "image")
    var image: String
)