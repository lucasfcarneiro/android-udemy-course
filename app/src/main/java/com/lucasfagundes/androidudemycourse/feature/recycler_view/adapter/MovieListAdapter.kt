package com.lucasfagundes.androidudemycourse.feature.recycler_view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucasfagundes.androidudemycourse.databinding.MovieItemRecyclerViewBinding

class MovieListAdapter (private val movieList: List<Movie>) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListAdapter.ViewHolder {
        val binding = MovieItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    class ViewHolder(private val binding: MovieItemRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movieTitleTextView.text = movie.title
            binding.movieYearTextView.text = movie.year
            binding.movieGenreTextView.text = movie.genre
        }
    }
}