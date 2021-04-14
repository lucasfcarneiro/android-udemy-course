package com.lucasfagundes.androidudemycourse.feature.learn_english.adapter

import android.provider.Settings.Global.getString
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.feature.learn_english.fragments.AnimalsFragment
import com.lucasfagundes.androidudemycourse.feature.learn_english.fragments.NumbersFragment
import com.lucasfagundes.androidudemycourse.feature.learn_english.fragments.VowelsFragment

class LearnEnglishPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AnimalsFragment()
            1 -> NumbersFragment()
            else -> VowelsFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "teste"
            1 ->
            else ->
        }
    }
}