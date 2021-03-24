package com.lucasfagundes.androidudemycourse.feature.media_player

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentMediaPlayerBinding

class MediaPlayerFragment : Fragment() {

    private lateinit var binding: FragmentMediaPlayerBinding
    private val media = MediaPlayer.create(context, R.raw.bach)
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentMediaPlayerBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.playButton.setOnClickListener(){
            playSound()
        }
        binding.pauseButton.setOnClickListener(){
            pauseSound()
        }
        binding.stopButton.setOnClickListener(){
            stopSound()
        }
    }

    private fun playSound() {
            media.start()
    }

    private fun pauseSound() {

    }

    private fun stopSound() {

    }

}