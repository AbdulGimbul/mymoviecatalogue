package com.example.abdl.mymoviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshowentities")
data class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "creator")
    var creator: String,

    @ColumnInfo(name = "year")
    var year: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "favorited")
    var favorited: Boolean = false,

    @ColumnInfo(name = "image")
    var image: String
)