package com.lucasfagundes.androidudemycourse.feature.random_number

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentRandomNumberBinding
import kotlin.random.Random

class RandomNumberFragment : Fragment() {

    private lateinit var binding: FragmentRandomNumberBinding

    override fun onCreateView(
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRandomNumberBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleButtonClick()
    }

    private fun handleButtonClick() {
        binding.playButton.setOnClickListener {
            setRandomNumber()
        }
    }

    private fun setRandomNumber() {
        val randomNumber = Random.nextInt(0, 20)
        binding.noNumberChosen.text = getString(R.string.number_answer, randomNumber.toString())
    }
}