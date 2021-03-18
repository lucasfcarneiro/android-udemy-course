package com.lucasfagundes.androidudemycourse.feature.atm_consultancy.ui.main_atm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentAtmMainBinding
import com.lucasfagundes.androidudemycourse.databinding.FragmentHomeBinding

class AtmMainFragment : Fragment() {

    private lateinit var binding: FragmentAtmMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAtmMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}