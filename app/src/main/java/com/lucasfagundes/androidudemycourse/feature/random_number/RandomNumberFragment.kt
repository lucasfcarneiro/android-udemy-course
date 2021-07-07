package com.lucasfagundes.androidudemycourse.feature.random_number

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentRandomNumberBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RandomNumberFragment : Fragment() {

    private lateinit var binding: FragmentRandomNumberBinding
    private val viewModel: RandomNumberViewModel by viewModel()

    override fun onCreateView(
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRandomNumberBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleButtonClick()
        handleObserver()
    }

    private fun handleButtonClick() {
        binding.playButton.setOnClickListener {
            viewModel.setRandomNumber()
        }
    }

    private fun handleObserver() {
        val result = Observer<String> { result ->
            binding.resultNumberTextView.text = result.toString()
        }
        viewModel.result.observe(viewLifecycleOwner, result)
    }
}