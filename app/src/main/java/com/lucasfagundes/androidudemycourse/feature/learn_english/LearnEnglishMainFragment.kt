package com.lucasfagundes.androidudemycourse.feature.learn_english

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentLearnEnglishMainBinding
import com.lucasfagundes.androidudemycourse.feature.learn_english.adapter.LearnEnglishPagerAdapter
import com.lucasfagundes.androidudemycourse.utils.setStatusBarColor

class LearnEnglishMainFragment : Fragment() {

    private lateinit var binding: FragmentLearnEnglishMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLearnEnglishMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()

        binding.viewPager.adapter = LearnEnglishPagerAdapter(childFragmentManager, this)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.viewPager.clearOnPageChangeListeners()

        setStatusBarColor(R.color.brown)
    }

    private fun setupToolbar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        binding.toolbarLearnEnglish.title = getString(R.string.learn_english)
        binding.toolbarLearnEnglish.setNavigationIcon(R.drawable.ic_arrow_back)
        binding.toolbarLearnEnglish.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        setStatusBarColor(R.color.purple_700)
    }
}