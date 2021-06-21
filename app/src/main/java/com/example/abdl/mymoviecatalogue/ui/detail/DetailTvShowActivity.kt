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
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity
import com.example.abdl.mymoviecatalogue.databinding.ActivityDetailTvShowBinding
import com.example.abdl.mymoviecatalogue.databinding.ContentDetailTvShowBinding
import com.example.abdl.mymoviecatalogue.viewmodel.ViewModelFactory
import com.example.abdl.mymoviecatalogue.vo.Status

class DetailTvShowActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    private lateinit var activityDetailTvShowBinding: ActivityDetailTvShowBinding
    private lateinit var detailTvShowBinding: ContentDetailTvShowBinding
    private lateinit var viewModel: DetailFilmCatalogueViewModel

    private var menu: Menu? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detailTvShowBinding = activityDetailTvShowBinding.detailTvshowContent

        setContentView(activityDetailTvShowBinding.root)

        setSupportActionBar(activityDetailTvShowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailFilmCatalogueViewModel::class.java]

        val extras = intent.extras
        if (extras != null){
            val tvshowId = extras.getString(EXTRA_TVSHOW)
            if (tvshowId != null){
                viewModel.setSelectedTvShow(tvshowId)

                viewModel.tvshowData.observe(this, { tvshowWithIdResource ->
                    if (tvshowWithIdResource != null) {
                        if (tvshowWithIdResource.data != null) {
                            when (tvshowWithIdResource.status) {
                                Status.LOADING -> activityDetailTvShowBinding.progressBar.visibility = View.VISIBLE
                                Status.SUCCESS -> {
                                    activityDetailTvShowBinding.progressBar.visibility = View.GONE
                                    val state = tvshowWithIdResource.data?.favorited
                                    setFavoriteState(state)
                                    populateTvShow(tvshowWithIdResource.data)
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
        viewModel.tvshowData.observe(this, { tvshow ->
            if (tvshow != null){
                when(tvshow.status){
                    Status.LOADING -> activityDetailTvShowBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (tvshow.data != null){
                        activityDetailTvShowBinding.progressBar.visibility = View.GONE
                        val state = tvshow.data.favorited
                        setFavoriteState(state)
                    }
                    Status.ERROR -> {
                        activityDetailTvShowBinding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_fav){
            viewModel.setFavoriteTvShow()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean){
        if (state == null) return
            val menuItem = menu?.findItem(R.id.action_fav)
        if (state){
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun populateTvShow(tvShowEntity: TvShowEntity){
        detailTvShowBinding.textTitleTvshow.text = tvShowEntity.title
        detailTvShowBinding.tvCreator.text = tvShowEntity.creator
        detailTvShowBinding.tvYearTvshow.text = tvShowEntity.year
        detailTvShowBinding.tvOverviewTvshow.text = tvShowEntity.overview

        Glide.with(this)
            .load(tvShowEntity.image)
            .transform(RoundedCorners(5))
            .apply(RequestOptions().override(55,55))
            .into(detailTvShowBinding.imgPosterTvshow)
    }
}