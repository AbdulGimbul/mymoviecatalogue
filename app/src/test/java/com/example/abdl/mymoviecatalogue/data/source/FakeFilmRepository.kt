package com.example.abdl.mymoviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.abdl.mymoviecatalogue.data.NetworkBoundResource
import com.example.abdl.mymoviecatalogue.data.source.local.LocalDataSource
import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity
import com.example.abdl.mymoviecatalogue.data.source.remote.ApiResponse
import com.example.abdl.mymoviecatalogue.data.source.remote.RemoteDataSource
import com.example.abdl.mymoviecatalogue.data.source.remote.response.MovieResponse
import com.example.abdl.mymoviecatalogue.data.source.remote.response.TvShowResponse
import com.example.abdl.mymoviecatalogue.utils.AppExecutors
import com.example.abdl.mymoviecatalogue.vo.Resource

class FakeFilmRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : FilmDataSource {
    override fun getAllMovies(): LiveData<Resource<PagedList<MoviesEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MoviesEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MoviesEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MoviesEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> {
                return remoteDataSource.getAllMovies()
            }

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MoviesEntity>()
                for (response in data) {
                    val movie = MoviesEntity(
                        response.movieId,
                        response.title,
                        response.director,
                        response.genre,
                        response.overview,
                        false,
                        response.image
                    )
                    movieList.add(movie)
                }

                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvshow(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> {
                return remoteDataSource.getAllTvShows()
            }

            override fun saveCallResult(data: List<TvShowResponse>) {
                val tvshowList = ArrayList<TvShowEntity>()
                for (response in data) {
                    val tvshow = TvShowEntity(
                        response.TvShowId,
                        response.title,
                        response.creator,
                        response.year,
                        response.overview,
                        false,
                        response.image
                    )
                    tvshowList.add(tvshow)
                }

                localDataSource.insertTvshow(tvshowList)
            }
        }.asLiveData()
    }

    override fun getMoviesById(movieId: String): LiveData<Resource<MoviesEntity>> {
        return object : NetworkBoundResource<MoviesEntity, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<MoviesEntity> {
                return localDataSource.getMovies(movieId)
            }

            override fun shouldFetch(data: MoviesEntity?): Boolean {
                return data?.movieId == null || data.movieId.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> {
                return remoteDataSource.getAllMovies()
            }

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MoviesEntity>()
                for (response in data) {
                    val movie = MoviesEntity(
                        response.movieId,
                        response.title,
                        response.director,
                        response.genre,
                        response.overview,
                        false,
                        response.image
                    )

                    movieList.add(movie)
                }

                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getTvShowById(tvshowId: String): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, List<TvShowResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> {
                return localDataSource.getTvShow(tvshowId)
            }

            override fun shouldFetch(data: TvShowEntity?): Boolean {
                return data?.tvShowId == null || data.tvShowId.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> {
                return remoteDataSource.getAllTvShows()
            }

            override fun saveCallResult(data: List<TvShowResponse>) {
                val tvshowList = ArrayList<TvShowEntity>()
                for (response in data) {
                    val tvshow = TvShowEntity(
                        response.TvShowId,
                        response.title,
                        response.creator,
                        response.year,
                        response.overview,
                        false,
                        response.image
                    )

                    tvshowList.add(tvshow)
                }

                localDataSource.insertTvshow(tvshowList)
            }
        }.asLiveData()
    }

    override fun getFavoritedMovies(): LiveData<PagedList<MoviesEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoritedMovies(), config).build()
    }

    override fun getFavoritedTvshow(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoritedTvshow(), config).build()
    }

    override fun setFavoritedMovies(movies: MoviesEntity, state: Boolean) {
        return appExecutors.diskIO().execute { localDataSource.setMoviesFavorite(movies, state) }
    }

    override fun setFavoritedTvshow(tvshow: TvShowEntity, state: Boolean) {
        return appExecutors.diskIO().execute { localDataSource.setTvshowFavorite(tvshow, state) }
    }
}