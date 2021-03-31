package com.lucasfagundes.androidudemycourse.feature.media_player

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.databinding.FragmentVideoBinding
import com.lucasfagundes.androidudemycourse.feature.atm_consultancy.AtmConsultancyActivity

class VideoFragment : Fragment() {

    private lateinit var binding: FragmentVideoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.playImageView.setOnClickListener() {
            playVideo()
        }
    }
    private fun playVideo(){
        val intent = Intent(activity, PlayerActivity::class.java)
        startActivity(intent)
    }
}
