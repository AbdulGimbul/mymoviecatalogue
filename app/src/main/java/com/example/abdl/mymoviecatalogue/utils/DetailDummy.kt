package com.example.abdl.mymoviecatalogue.utils

import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity

object DetailDummy {
    fun getDetailMovie(movieId: String): MoviesEntity {
        return MoviesEntity(
            "mv1",
            "Start is Born",
            "Stefano Sollima",
            "Action, Adventure, Thriller, War",
            "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
            false,
            "https://www.themoviedb.org/t/p/w220_and_h330_face/6wxfWZxQcuv2QgxIQKj0eYTdKTv.jpg"
        )
    }

    fun getDetailTvShow(tvshowId: String): TvShowEntity {
        return TvShowEntity(
            "tv1",
            "Fairytail",
            "David Shore",
            "2017",
            "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
            false,
            "https://www.themoviedb.org/t/p/w220_and_h330_face/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg"
        )
    }
}