package com.example.abdl.mymoviecatalogue.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowEntity(
    var TvShowId: String,
    var title: String,
    var creator: String,
    var year: String,
    var overview: String,
    var image: String
): Parcelable