package com.example.abdl.mymoviecatalogue

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.abdl.mymoviecatalogue.databinding.ActivityFavoriteBinding
import com.example.abdl.mymoviecatalogue.ui.favorites.SectionsPagerAdapter

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        activityFavoriteBinding.viewPager.adapter = sectionsPagerAdapter
        activityFavoriteBinding.tabs.setupWithViewPager(activityFavoriteBinding.viewPager)

        supportActionBar?.elevation = 0f
    }
}