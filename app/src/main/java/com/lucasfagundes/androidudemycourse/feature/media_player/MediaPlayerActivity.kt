package com.lucasfagundes.androidudemycourse.feature.media_player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.ActivityMediaPlayerBinding
import com.lucasfagundes.androidudemycourse.databinding.FragmentMediaPlayerBinding

class MediaPlayerActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMediaPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }//fun

}