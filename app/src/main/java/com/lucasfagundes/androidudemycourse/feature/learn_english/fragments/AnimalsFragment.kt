package com.lucasfagundes.androidudemycourse.feature.learn_english.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentAnimalsBinding

class AnimalsFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentAnimalsBinding
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentAnimalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        applyClickEvent()
    }

    private fun applyClickEvent() {
        binding.catImageView.setOnClickListener(this)
        binding.dogImageView.setOnClickListener(this)
        binding.cowImageView.setOnClickListener(this)
        binding.sheepImageView.setOnClickListener(this)
        binding.lionImageView.setOnClickListener(this)
        binding.monkeyImageView.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.catImageView -> {
                playSound(R.raw.cat)
            }
            R.id.dogImageView -> {
                playSound(R.raw.dog)
            }
            R.id.monkeyImageView -> {
                playSound(R.raw.monkey)
            }
            R.id.lionImageView -> {
                playSound(R.raw.lion)
            }
            R.id.cowImageView -> {
                playSound(R.raw.cow)
            }
            R.id.sheepImageView -> {
                playSound(R.raw.sheep)
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