package com.lucasfagundes.androidudemycourse.feature.beer_values

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import com.google.android.material.textfield.TextInputEditText
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentBeerValuesBinding
import com.lucasfagundes.androidudemycourse.utils.hideKeyboard

class BeerValuesFragment : Fragment() {

    private lateinit var binding: FragmentBeerValuesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBeerValuesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.calcButton.setOnClickListener {
            val firstRadioButtonValue = checkRadioButtonSelection(binding.firstRadioGroup)
            val secondRadioButtonValue = checkRadioButtonSelection(binding.secondRadioGroup)

            if (firstRadioButtonValue == 0.0 && secondRadioButtonValue == 0.0) {
                val x = binding.firstMLEditText.text.toString()
                val y = binding.secondMLEditText.text.toString()
                val resultado1 = calculatePrice(x.toDouble(), binding.firstPriceEditText)
                val resultado2 = calculatePrice(y.toDouble(), binding.firstPriceEditText)

                when {
                    resultado1 > resultado2 -> {
                        binding.resultFinalTextView.text = getString(
                            R.string.better_second_option,
                            secondRadioButtonValue.toString()
                        )
                    }
                    resultado1 == resultado2 -> {
                        binding.resultFinalTextView.text = getString(R.string.equal_prices)
                    }
                    else -> binding.resultFinalTextView.text =
                        getString(R.string.better_first_option, firstRadioButtonValue.toString())
                }

                binding.resultFirstTextView.text =
                    getString(R.string.liter_price, resultado1.toString().format("%.2f"))
                binding.resultSecondTextView.text =
                    getString(R.string.liter_price, resultado2.toString().format("%.2f"))

            } else {
                val firstLiterPrice =
                    calculatePrice(firstRadioButtonValue, binding.firstPriceEditText)
                val secondLiterPrice =
                    calculatePrice(secondRadioButtonValue, binding.secondPriceEditText)

                when {
                    firstLiterPrice > secondLiterPrice -> {
                        binding.resultFinalTextView.text = getString(
                            R.string.better_second_option,
                            secondRadioButtonValue.toString()
                        )
                    }
                    firstLiterPrice == secondLiterPrice -> {
                        binding.resultFinalTextView.text = getString(R.string.equal_prices)
                    }
                    else -> binding.resultFinalTextView.text =
                        getString(R.string.better_first_option, firstRadioButtonValue.toString())
                }

                binding.resultFirstTextView.text =
                    getString(R.string.liter_price, firstLiterPrice.toString().format("%.2f"))
                binding.resultSecondTextView.text =
                    getString(R.string.liter_price, secondLiterPrice.toString().format("%.2f"))

            }
            hideKeyboard()
        }
        binding.cleanButton.setOnClickListener { cleanFields() }
    }//funçoes

    private fun calculatePrice(canValue: Double, unitPrice: TextInputEditText): Double {
        val numberOfCans = 1000 / canValue
        return numberOfCans * unitPrice.text.toString().toDouble()
    }

    private fun checkRadioButtonSelection(radioGroup: RadioGroup): Double {
        //return when (findViewById<View>(radioGroup.checkedRadioButtonId) as RadioButton) {
        return when ((radioGroup.checkedRadioButtonId) as RadioButton) {
            binding.Ml250Radio, binding.Ml250Radio2 -> {
                250.0
            }
            binding.Ml350Radio, binding.Ml350Radio2 -> {
                350.0
            }
            binding.Ml473Radio, binding.Ml473Radio2 -> {
                473.0
            }
            binding.Ml600Radio, binding.Ml600Radio2 -> {
                600.0
            }
            else -> {
                0.0
            }
        }
    }

    private fun cleanFields() {
        binding.firstPriceEditText.setText("")
        binding.secondPriceEditText.setText("")
        binding.resultFirstTextView.text = ""
        binding.resultSecondTextView.text = ""
        binding.resultFinalTextView.text = ""
        binding.secondRadioGroup.clearCheck()
        binding.firstRadioGroup.clearCheck()
    }
}


//"O preço do litro é: ${String.format("%.2f", secondLiterPrice)} reais"
//"Melhor comprar a segunda opção: ${secondRadioButtonValue.toInt()} ML"