package com.example.abdl.mymoviecatalogue.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.abdl.mymoviecatalogue.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {
    private lateinit var fragmentFavoritesBinding: FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFavoritesBinding =
            FragmentFavoritesBinding.inflate(layoutInflater, container, false)
        return fragmentFavoritesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val sectionsPagerAdapter = SectionsPagerAdapter(requireContext(), childFragmentManager)
            fragmentFavoritesBinding.viewPager.adapter = sectionsPagerAdapter
            fragmentFavoritesBinding.tabs.setupWithViewPager(fragmentFavoritesBinding.viewPager)

        }
    }

}