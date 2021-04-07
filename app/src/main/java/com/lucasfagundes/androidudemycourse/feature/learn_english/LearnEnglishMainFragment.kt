package com.lucasfagundes.androidudemycourse.feature.learn_english

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.ActivityMainBinding
import com.lucasfagundes.androidudemycourse.databinding.FragmentLearnEnglishMainBinding
import com.lucasfagundes.androidudemycourse.feature.learn_english.adapter.LearnEnglishPagerAdapter

class LearnEnglishMainFragment : Fragment() {

    private lateinit var binding: FragmentLearnEnglishMainBinding
    private lateinit var activityBinding : ActivityMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLearnEnglishMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = LearnEnglishPagerAdapter(childFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.viewPager.clearOnPageChangeListeners()
        changeStatusBarColor()

        //activityBinding.appBarMain.mainToolbar.setBackgroundColor(R.color.brown)
    }

    private fun changeStatusBarColor() {
        val window: Window = requireActivity().window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

        window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.brown)
    }
}