package com.lucasfagundes.androidudemycourse.feature.media_player.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.databinding.FragmentVideoPlayerBinding

class VideoPlayerFragment : Fragment() {

    private lateinit var binding: FragmentVideoPlayerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideoPlayerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.playImageView.setOnClickListener() {
            playVideo()
        }
    }
    private fun playVideo(){
        val intent = Intent(activity, PlayerActivity::class.java)
        startActivity(intent)
    }
}
