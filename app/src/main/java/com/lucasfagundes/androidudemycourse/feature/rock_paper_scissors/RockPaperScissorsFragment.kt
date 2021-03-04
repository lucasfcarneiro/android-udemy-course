package com.lucasfagundes.androidudemycourse.feature.rock_paper_scissors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentRockPaperScissorsBinding
import kotlin.random.Random
import com.lucasfagundes.androidudemycourse.feature.rock_paper_scissors.ChoiceOptions.PAPER
import com.lucasfagundes.androidudemycourse.feature.rock_paper_scissors.ChoiceOptions.SCISSORS
import com.lucasfagundes.androidudemycourse.feature.rock_paper_scissors.ChoiceOptions.ROCK

class RockPaperScissorsFragment : Fragment() {

    private lateinit var binding: FragmentRockPaperScissorsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View? {
        binding = FragmentRockPaperScissorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUserChoice()
    }

    private fun checkWinner(app: ChoiceOptions, user: ChoiceOptions) {
        if ((app == ROCK && user == SCISSORS) ||
            (app == SCISSORS && user == PAPER) ||
            (app == PAPER && user == ROCK)
        ) {
            binding.resultTextView.text = getString(R.string.you_lose)
        } else if ((user == ROCK && app == SCISSORS) ||
            (user == SCISSORS && app == PAPER) ||
            (user == PAPER && app == ROCK)
        ) {
            binding.resultTextView.text = getString(R.string.you_win)
        } else {
            binding.resultTextView.text = getString(R.string.you_draw)
        }
    }

    private fun setAppChoice(): ChoiceOptions {
        var appChoice = ChoiceOptions.NULL
        when (Random.nextInt(3)) {
            0 -> {
                binding.appChoiceImageView.setImageResource(R.drawable.rock_hand)
                appChoice = ROCK
            }
            1 -> {
                binding.appChoiceImageView.setImageResource(R.drawable.paper_hand)
                appChoice = PAPER
            }
            2 -> {
                binding.appChoiceImageView.setImageResource(R.drawable.scissors_hand)
                appChoice = SCISSORS
            }
        }
        return appChoice
    }

    private fun setUserChoice() {
        binding.rockHandImageView.setOnClickListener {
            checkWinner(setAppChoice(), ROCK)
        }
        binding.paperHandImageView.setOnClickListener {
            checkWinner(setAppChoice(), PAPER)
        }
        binding.scissorHandImageView.setOnClickListener {
            checkWinner(setAppChoice(), SCISSORS)
        }
    }
}