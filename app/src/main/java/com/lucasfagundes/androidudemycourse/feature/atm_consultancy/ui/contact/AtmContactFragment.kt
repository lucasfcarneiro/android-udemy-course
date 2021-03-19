package com.lucasfagundes.androidudemycourse.feature.atm_consultancy.ui.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentAtmContactBinding
import com.lucasfagundes.androidudemycourse.databinding.FragmentAtmMainBinding

class AtmContactFragment : Fragment() {

    lateinit var binding: FragmentAtmContactBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAtmContactBinding.inflate(inflater, container, false)
        return binding.root
    }
}