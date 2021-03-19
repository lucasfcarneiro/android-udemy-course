package com.lucasfagundes.androidudemycourse.feature.atm_consultancy.ui.service

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentAboutAtmBinding
import com.lucasfagundes.androidudemycourse.databinding.FragmentAtmMainBinding
import com.lucasfagundes.androidudemycourse.databinding.FragmentAtmServiceBinding

class AtmServiceFragment : Fragment() {

    lateinit var binding: FragmentAtmServiceBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAtmServiceBinding.inflate(inflater, container, false)
        return binding.root
    }
}