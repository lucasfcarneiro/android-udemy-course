package com.lucasfagundes.androidudemycourse.feature.media_player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucasfagundes.androidudemycourse.databinding.ActivityMediaPlayerBinding

class MediaPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMediaPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val fragmentAdapter = PagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = fragmentAdapter

        binding.tabLayout.setupWithViewPager(binding.viewPager)

    }//fun

}


