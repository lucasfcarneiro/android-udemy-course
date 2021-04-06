package com.lucasfagundes.androidudemycourse.feature.learn_english

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.databinding.FragmentLearnEnglishMainBinding

class LearnEnglishMainFragment : Fragment() {

    private lateinit var binding : FragmentLearnEnglishMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLearnEnglishMainBinding.inflate(inflater,container,false)
        return binding.root
    }


}