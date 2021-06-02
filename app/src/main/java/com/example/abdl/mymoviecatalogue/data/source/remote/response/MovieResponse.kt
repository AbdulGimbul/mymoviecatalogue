package com.example.abdl.mymoviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    var movieId: String,
    var title: String,
    var director: String,
    var genre: String,
    var overview: String,
    var image: String
): Parcelable
