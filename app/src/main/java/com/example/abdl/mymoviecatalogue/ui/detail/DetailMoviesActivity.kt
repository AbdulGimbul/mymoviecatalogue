package com.example.abdl.mymoviecatalogue.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.abdl.mymoviecatalogue.R
import com.example.abdl.mymoviecatalogue.data.source.local.entity.MoviesEntity
import com.example.abdl.mymoviecatalogue.databinding.ActivityDetailMoviesBinding
import com.example.abdl.mymoviecatalogue.databinding.ContentDetailMoviesBinding
import com.example.abdl.mymoviecatalogue.viewmodel.ViewModelFactory
import com.example.abdl.mymoviecatalogue.vo.Status

class DetailMoviesActivity : AppCompatActivity() {

    private lateinit var activityDetailMoviesBinding: ActivityDetailMoviesBinding
    private lateinit var detailMoviesBinding: ContentDetailMoviesBinding
    private lateinit var viewModel: DetailFilmCatalogueViewModel

    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailMoviesBinding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        detailMoviesBinding = activityDetailMoviesBinding.detailMoviesContent

        setContentView(activityDetailMoviesBinding.root)

        setSupportActionBar(activityDetailMoviesBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailFilmCatalogueViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val moviesId = extras.getString(EXTRA_MOVIES)
            if (moviesId != null) {
                viewModel.setSelectedMovies(moviesId)

                viewModel.moviesData.observe(this, { moviesWithIdResource ->
                    if (moviesWithIdResource != null) {
                        if (moviesWithIdResource.data != null) {
                            when (moviesWithIdResource.status) {
                                Status.LOADING -> activityDetailMoviesBinding.progressBar.visibility =
                                    View.VISIBLE
                                Status.SUCCESS -> {
                                    activityDetailMoviesBinding.progressBar.visibility = View.GONE
                                    val state = moviesWithIdResource.data?.favorited
                                    setFavoriteState(state)
                                    populateMovies(moviesWithIdResource.data)
                                }
                            }
                        }
                    }
                })
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        this.menu = menu
        viewModel.moviesData.observe(this, { movies ->
            if (movies != null) {
                when (movies.status) {
                    Status.LOADING -> activityDetailMoviesBinding.progressBar.visibility =
                        View.VISIBLE
                    Status.SUCCESS -> if (movies.data != null) {
                        activityDetailMoviesBinding.progressBar.visibility = View.GONE
                        val state = movies.data.favorited
                        setFavoriteState(state)
                    }
                    Status.ERROR -> {
                        activityDetailMoviesBinding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_fav) {
            viewModel.setFavoriteMovies()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (state == null) return
        val menuItem = menu?.findItem(R.id.action_fav)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24)
        } else {
            menuItem?.icon =
                ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun populateMovies(moviesEntity: MoviesEntity) {
        detailMoviesBinding.textTitleMovies.text = moviesEntity.title
        detailMoviesBinding.tvDirector.text = moviesEntity.director
        detailMoviesBinding.tvGenreMovies.text = moviesEntity.genre
        detailMoviesBinding.tvOverview.text = moviesEntity.overview

        Glide.with(this)
            .load(moviesEntity.image)
            .transform(RoundedCorners(5))
            .apply(RequestOptions().override(55, 55))
            .into(detailMoviesBinding.imgPosterMovies)
    }

    companion object {
        const val EXTRA_MOVIES = "extra_movies"
    }
}