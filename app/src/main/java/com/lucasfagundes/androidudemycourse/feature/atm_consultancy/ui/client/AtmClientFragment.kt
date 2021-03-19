package com.lucasfagundes.androidudemycourse.feature.atm_consultancy.ui.client

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.databinding.FragmentAtmClientBinding

class AtmClientFragment : Fragment() {

    lateinit var binding: FragmentAtmClientBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAtmClientBinding.inflate(inflater, container, false)
        return binding.root
    }
}