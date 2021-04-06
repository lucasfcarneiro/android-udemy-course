package com.lucasfagundes.androidudemycourse.feature.learn_english.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.databinding.FragmentAnimalsBinding

class AnimalsFragment : Fragment() {

    private lateinit var binding: FragmentAnimalsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAnimalsBinding.inflate(inflater, container, false)
        return binding.root
    }

}