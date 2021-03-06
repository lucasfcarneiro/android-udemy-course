package com.lucasfagundes.androidudemycourse.feature.media_player.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucasfagundes.androidudemycourse.databinding.ActivityMediaPlayerBinding
import com.lucasfagundes.androidudemycourse.feature.media_player.adapter.MediaPlayerPagerAdapter

class MediaPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMediaPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaPlayerBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMediaPlayer)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.viewPager.adapter = MediaPlayerPagerAdapter(supportFragmentManager,this)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.viewPager.clearOnPageChangeListeners()

        binding.toolbarMediaPlayer.setNavigationOnClickListener {
            finish()
        }
    }
}