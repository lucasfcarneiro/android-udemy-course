package com.lucasfagundes.androidudemycourse.feature.recycler_view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.feature.recycler_view.adapter.Movie
import com.lucasfagundes.androidudemycourse.feature.recycler_view.adapter.MovieListAdapter
import com.lucasfagundes.androidudemycourse.databinding.FragmentRecyclerViewBinding

class RecyclerViewFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerViewBinding
    private lateinit var movieListAdapter : MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //config recycler view
        movieListAdapter = MovieListAdapter(Movie.DUMBLIST)
        binding.movieRecyclerView.adapter = movieListAdapter
    }
}