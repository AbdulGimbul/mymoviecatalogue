package com.example.abdl.mymoviecatalogue.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.abdl.mymoviecatalogue.data.source.local.entity.TvShowEntity
import com.example.abdl.mymoviecatalogue.databinding.ActivityDetailTvShowBinding
import com.example.abdl.mymoviecatalogue.databinding.ContentDetailTvShowBinding
import com.example.abdl.mymoviecatalogue.viewmodel.ViewModelFactory

class DetailTvShowActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    private lateinit var detailTvShowBinding: ContentDetailTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        detailTvShowBinding = activityDetailTvShowBinding.detailTvshowContent

        setContentView(activityDetailTvShowBinding.root)

        setSupportActionBar(activityDetailTvShowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailFilmCatalogueViewModel::class.java]

        val extras = intent.extras
        if (extras != null){
            val tvshowId = extras.getString(EXTRA_TVSHOW)
            if (tvshowId != null){
                activityDetailTvShowBinding.progressBar.visibility = View.VISIBLE
                detailTvShowBinding.contentTvshow.visibility = View.INVISIBLE

                viewModel.setSelectedTvShow(tvshowId)
                viewModel.getTvShow().observe(this, { tvshow ->
                    activityDetailTvShowBinding.progressBar.visibility = View.GONE
                    detailTvShowBinding.contentTvshow.visibility = View.VISIBLE

                    populateTvShow(tvshow) })
            }
        }
    }

    private fun populateTvShow(tvShowEntity: TvShowEntity){
        detailTvShowBinding.textTitleTvshow.text = tvShowEntity.title
        detailTvShowBinding.tvCreator.text = tvShowEntity.creator
        detailTvShowBinding.tvYearTvshow.text = tvShowEntity.year
        detailTvShowBinding.tvOverviewTvshow.text = tvShowEntity.overview

        Glide.with(this)
            .load(tvShowEntity.image)
            .transform(RoundedCorners(20))
            .apply(RequestOptions().override(55,55))
            .into(detailTvShowBinding.imgPosterTvshow)
    }
}