package com.example.abdl.mymoviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity
import com.example.abdl.mymoviecatalogue.data.source.remote.RemoteDataSource
import com.example.abdl.mymoviecatalogue.data.source.remote.response.MovieResponse
import com.example.abdl.mymoviecatalogue.data.source.remote.response.TvShowResponse

open class FilmRepository private constructor(private val remoteDataSource: RemoteDataSource): FilmDataSource{
    companion object{
        @Volatile
        private var instance: FilmRepository? = null

        fun getInstance(remoteData: RemoteDataSource): FilmRepository =
            instance ?: synchronized(this){
                instance ?: FilmRepository(remoteData).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<List<MoviesEntity>> {
        val movieResults = MutableLiveData<List<MoviesEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback{
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                val movieList = ArrayList<MoviesEntity>()
                for (response in movieResponse){
                    val movie = MoviesEntity(
                        response.movieId,
                        response.title,
                        response.director,
                        response.genre,
                        response.overview,
                        response.image
                    )
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getAllTvShows(): LiveData<List<TvShowEntity>> {
        val tvshowResults = MutableLiveData<List<TvShowEntity>>()
        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowCallback{
            override fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>) {
                val tvshowList = ArrayList<TvShowEntity>()
                for (response in tvShowResponse) {
                    val tvshow = TvShowEntity(
                        response.TvShowId,
                        response.title,
                        response.creator,
                        response.year,
                        response.overview,
                        response.image
                    )
                    tvshowList.add(tvshow)
                }
                tvshowResults.postValue(tvshowList)
            }
        })
        return tvshowResults
    }


    override fun getDetailMovies(movieId: String): LiveData<MoviesEntity> {
        val detailMovieResult = MutableLiveData<MoviesEntity>()

        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback{
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                lateinit var movie: MoviesEntity
                for (response in movieResponse){
                    if (response.movieId == movieId){
                        movie = MoviesEntity(
                            response.movieId,
                            response.title,
                            response.director,
                            response.genre,
                            response.overview,
                            response.image
                        )
                    }
                }
                detailMovieResult.postValue(movie)
            }
        })
        return detailMovieResult
    }

    override fun getDetailTvShow(tvshowId: String): LiveData<TvShowEntity> {
        val detailTvShowResult = MutableLiveData<TvShowEntity>()
        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowCallback{
            override fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>) {
                lateinit var tvshow: TvShowEntity
                for (response in tvShowResponse){
                    if (response.TvShowId == tvshowId){
                        tvshow = TvShowEntity(
                            response.TvShowId,
                            response.title,
                            response.creator,
                            response.year,
                            response.overview,
                            response.image
                        )
                    }
                }
                detailTvShowResult.postValue(tvshow)
            }
        })
        return detailTvShowResult
    }
}