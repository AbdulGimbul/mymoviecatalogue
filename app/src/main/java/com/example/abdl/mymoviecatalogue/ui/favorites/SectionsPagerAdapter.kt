package com.example.abdl.mymoviecatalogue.ui.favorites

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.abdl.mymoviecatalogue.R
import com.example.abdl.mymoviecatalogue.ui.favorites.movies.MoviesFavoriteFragment
import com.example.abdl.mymoviecatalogue.ui.favorites.tvshow.TvShowFavoriteFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies, R.string.tv_show)
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MoviesFavoriteFragment()
            1 -> TvShowFavoriteFragment()
            else -> Fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }
}