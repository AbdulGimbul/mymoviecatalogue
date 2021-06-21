package com.example.abdl.mymoviecatalogue.ui.favorites.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abdl.mymoviecatalogue.databinding.FragmentTvShowFavoriteBinding
import com.example.abdl.mymoviecatalogue.ui.tvshow.TvShowAdapter
import com.example.abdl.mymoviecatalogue.viewmodel.ViewModelFactory

class TvShowFavoriteFragment : Fragment() {
    private lateinit var fragmentTvShowFavoriteBinding: FragmentTvShowFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentTvShowFavoriteBinding =
            FragmentTvShowFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowFavoriteViewModel::class.java]

            val tvShowAdapter = TvShowAdapter()

            fragmentTvShowFavoriteBinding.progressBar.visibility = View.VISIBLE
            viewModel.getTvShowFavorited().observe(viewLifecycleOwner, { tvshow ->
                fragmentTvShowFavoriteBinding.progressBar.visibility = View.GONE
                tvShowAdapter.submitList(tvshow)
            })

            with(fragmentTvShowFavoriteBinding.rvFavTvshow) {
                layoutManager = LinearLayoutManager(context)
                this.adapter = tvShowAdapter
            }
        }
    }

}