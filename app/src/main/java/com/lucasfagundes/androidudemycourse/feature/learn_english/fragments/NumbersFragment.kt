package com.lucasfagundes.androidudemycourse.feature.learn_english.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentNumbersBinding

class NumbersFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentNumbersBinding
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentNumbersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        applyClickEvent()
    }

    private fun applyClickEvent() {
        binding.oneImageView.setOnClickListener(this)
        binding.twoImageView.setOnClickListener(this)
        binding.threeImageView.setOnClickListener(this)
        binding.fourImageView.setOnClickListener(this)
        binding.fiveImageView.setOnClickListener(this)
        binding.sixImageView.setOnClickListener(this)
    }


    override fun onClick(view: View) {
        when (view.id) {
            R.id.oneImageView -> {
                playSound(R.raw.one)
            }
            R.id.twoImageView -> {
                playSound(R.raw.two)
            }
            R.id.threeImageView -> {
                playSound(R.raw.three)
            }
            R.id.fourImageView -> {
                playSound(R.raw.four)
            }
            R.id.fiveImageView -> {
                playSound(R.raw.five)
            }
            R.id.sixImageView -> {
                playSound(R.raw.six)
            }
        }
    }

    private fun playSound(Sound: Int) {
        mediaPlayer = MediaPlayer.create(activity, Sound)

        mediaPlayer.apply {
            start()
            setOnCompletionListener {
                release()
            }
        }
    }
}