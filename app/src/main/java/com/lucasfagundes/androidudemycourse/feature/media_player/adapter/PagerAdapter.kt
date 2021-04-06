package com.lucasfagundes.androidudemycourse.feature.media_player.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.lucasfagundes.androidudemycourse.feature.media_player.fragments.MusicPlayerFragment
import com.lucasfagundes.androidudemycourse.feature.media_player.fragments.VideoPlayerFragment

class PagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MusicPlayerFragment()
            else -> VideoPlayerFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Musica"
            else -> "Video"
        }
    }
}