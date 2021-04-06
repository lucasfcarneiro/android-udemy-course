package com.lucasfagundes.androidudemycourse.feature.learn_english

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.PagerAdapter
import com.lucasfagundes.androidudemycourse.databinding.ActivityLearnEnglishBinding
import com.lucasfagundes.androidudemycourse.feature.learn_english.adapter.PagerAdapter2

class LearnEnglishActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLearnEnglishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLearnEnglishBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar1)

        binding.viewPager.adapter = PagerAdapter2(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.viewPager.clearOnPageChangeListeners()
    }

}