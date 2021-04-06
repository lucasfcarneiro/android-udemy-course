package com.lucasfagundes.androidudemycourse.feature.learn_english.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.databinding.FragmentVowelsBinding

class VowelsFragment : Fragment() {
    private lateinit var binding: FragmentVowelsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentVowelsBinding.inflate(inflater, container, false)
        return binding.root
    }

}