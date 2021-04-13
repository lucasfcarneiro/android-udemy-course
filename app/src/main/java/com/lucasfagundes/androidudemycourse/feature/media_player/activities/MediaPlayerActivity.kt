package com.lucasfagundes.androidudemycourse.feature.media_player.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucasfagundes.androidudemycourse.databinding.ActivityMediaPlayerBinding
import com.lucasfagundes.androidudemycourse.feature.media_player.adapter.PagerAdapter

class MediaPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMediaPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaPlayerBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.viewPager.adapter = PagerAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.viewPager.clearOnPageChangeListeners()

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}


