package com.example.abdl.mymoviecatalogue.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity
import com.example.abdl.mymoviecatalogue.databinding.ActivityDetailMoviesBinding
import com.example.abdl.mymoviecatalogue.databinding.ContentDetailMoviesBinding
import com.example.abdl.mymoviecatalogue.utils.DataDummy
import com.example.abdl.mymoviecatalogue.viewmodel.ViewModelFactory

class DetailMoviesActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_MOVIES = "extra_movies"
    }

    private lateinit var detailMoviesBinding: ContentDetailMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMoviesBinding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        detailMoviesBinding = activityDetailMoviesBinding.detailMoviesContent

        setContentView(activityDetailMoviesBinding.root)

        setSupportActionBar(activityDetailMoviesBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailFilmCatalogueViewModel::class.java]

        val extras = intent.extras
        if (extras != null){
            val moviesId = extras.getString(EXTRA_MOVIES)
            if (moviesId != null){
                activityDetailMoviesBinding.progressBar.visibility = View.VISIBLE
                detailMoviesBinding.contentMovies.visibility = View.INVISIBLE

                viewModel.setSelectedMovies(moviesId)
                viewModel.getMovies().observe(this, { movie ->
                    activityDetailMoviesBinding.progressBar.visibility = View.INVISIBLE
                    detailMoviesBinding.contentMovies.visibility = View.VISIBLE

                    populateMovies(movie) })
            }
        }
    }

    private fun populateMovies(moviesEntity: MoviesEntity){
        detailMoviesBinding.textTitleMovies.text = moviesEntity.title
        detailMoviesBinding.tvDirector.text = moviesEntity.director
        detailMoviesBinding.tvGenreMovies.text = moviesEntity.genre
        detailMoviesBinding.tvOverview.text = moviesEntity.overview

        Glide.with(this)
            .load(moviesEntity.image)
            .transform(RoundedCorners(20))
            .apply(RequestOptions().override(55,55))
            .into(detailMoviesBinding.imgPosterMovies)
    }
}