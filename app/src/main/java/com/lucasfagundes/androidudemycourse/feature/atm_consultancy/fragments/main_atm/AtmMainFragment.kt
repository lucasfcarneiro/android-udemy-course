package com.lucasfagundes.androidudemycourse.feature.atm_consultancy.fragments.main_atm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.databinding.FragmentAtmMainBinding

class AtmMainFragment : Fragment() {

    lateinit var binding: FragmentAtmMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAtmMainBinding.inflate(inflater, container, false)
        return binding.root
    }
}