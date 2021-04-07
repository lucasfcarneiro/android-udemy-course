package com.lucasfagundes.androidudemycourse.feature.learn_english

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.ActivityLearnEnglishBinding
import com.lucasfagundes.androidudemycourse.feature.learn_english.adapter.PagerAdapter

class LearnEnglishActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLearnEnglishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLearnEnglishBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbarLearnEnglish)

        binding.viewPager.adapter = PagerAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.viewPager.clearOnPageChangeListeners()

        changeStatusBarColor()

    }

    private fun changeStatusBarColor() {
        val window: Window = this.window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

            window.statusBarColor = ContextCompat.getColor(this, R.color.brown)

    }

}