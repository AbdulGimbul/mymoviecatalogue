package com.example.abdl.mymoviecatalogue.ui.favorites.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abdl.mymoviecatalogue.databinding.FragmentMoviesFavoriteBinding
import com.example.abdl.mymoviecatalogue.ui.movies.MoviesAdapter
import com.example.abdl.mymoviecatalogue.viewmodel.ViewModelFactory

class MoviesFavoriteFragment : Fragment() {
    private lateinit var fragmentMoviesFavoriteBinding: FragmentMoviesFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentMoviesFavoriteBinding =
            FragmentMoviesFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentMoviesFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MoviesFavoriteViewModel::class.java]

            val moviesAdapter = MoviesAdapter()

            fragmentMoviesFavoriteBinding.progressBar.visibility = View.VISIBLE
            viewModel.getMoviesFavorited().observe(viewLifecycleOwner, { movies ->
                fragmentMoviesFavoriteBinding.progressBar.visibility = View.GONE
                moviesAdapter.submitList(movies)
            })

            with(fragmentMoviesFavoriteBinding.rvFavMovies) {
                layoutManager = LinearLayoutManager(context)
                this.adapter = moviesAdapter
            }
        }
    }
}