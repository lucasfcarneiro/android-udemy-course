package com.lucasfagundes.androidudemycourse.feature.media_player.activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.ActivityPlayerBinding

class VideoPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val videoView = binding.playerVideoView
        val mediaController = MediaController(this)

        mediaController.setAnchorView(videoView)
        handleVideoView(videoView, mediaController)
    }

    private fun handleVideoView(videoView: VideoView, mediaController: MediaController) {
        videoView.apply {
            setMediaController(mediaController)
            setVideoURI(Uri.parse("android.resource://$packageName/${R.raw.rick_morty_intro_video}"))
            requestFocus()
            start()
        }
    }
}