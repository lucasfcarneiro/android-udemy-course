package com.lucasfagundes.androidudemycourse.feature.beer_values

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentBeerValuesBinding
import com.lucasfagundes.androidudemycourse.utils.hideKeyboard
import com.lucasfagundes.androidudemycourse.utils.toPrice

class BeerValuesFragment : Fragment() {

    private lateinit var binding: FragmentBeerValuesBinding

    private var firstRadioGroupSelected = false
    private var secondRadioGroupSelected = false
    private var firstMlValue: Double = 0.0
    private var secondMlValue: Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentBeerValuesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleRadioGroup(binding.firstRadioGroup)
        handleRadioGroup(binding.secondRadioGroup)

        binding.calcButton.setOnClickListener {
            if (validateFields()) {
                displayResults()
            }
        }
        binding.cleanButton.setOnClickListener { cleanFields() }
    }

    private fun validateFields(): Boolean {
        return validateInput(binding.firstPriceEditText.text.toString(),
            binding.secondPriceEditText.text.toString()) && validateRadioGroup()
    }

    private fun validateInput(text: String, text2: String): Boolean {
        val isValid: Boolean
        if (text.isBlank() || text2.isBlank()) {
            isValid = false
            Toast.makeText(context, R.string.enter_all_fields, Toast.LENGTH_SHORT).show()
        } else {
            isValid = true
        }
        return isValid
    }

    private fun validateRadioGroup(): Boolean {
        val isValid: Boolean
        if (firstRadioGroupSelected && secondRadioGroupSelected) {
            isValid = true
        } else {
            isValid = false
            Toast.makeText(context, R.string.select_all_measures, Toast.LENGTH_SHORT).show()
        }
        return isValid
    }

    private fun setRadioGroupSelected(radio: RadioGroup) {
        when (radio.id) {
            R.id.firstRadioGroup -> firstRadioGroupSelected = true
            R.id.secondRadioGroup -> secondRadioGroupSelected = true
        }
    }

    private fun setMlValue(radio: RadioGroup, mlValue: Double) {
        when (radio.id) {
            R.id.firstRadioGroup -> firstMlValue = mlValue
            R.id.secondRadioGroup -> secondMlValue = mlValue
        }
    }

    private fun handleRadioGroup(radioGroup: RadioGroup) {
        radioGroup.setOnCheckedChangeListener { radioGroup, id ->
            when (id) {
                R.id.Ml250Radio, R.id.Ml250Radio2 -> {
                    setRadioGroupSelected(radioGroup)
                    setMlValue(radioGroup, 250.0)
                }
                R.id.Ml350Radio, R.id.Ml350Radio2 -> {
                    setRadioGroupSelected(radioGroup)
                    setMlValue(radioGroup, 350.0)
                }
                R.id.Ml473Radio, R.id.Ml473Radio2 -> {
                    setRadioGroupSelected(radioGroup)
                    setMlValue(radioGroup, 473.0)
                }
                R.id.Ml600Radio, R.id.Ml600Radio2 -> {
                    setRadioGroupSelected(radioGroup)
                    setMlValue(radioGroup, 600.0)
                }
            }
            hideKeyboard()
        }
    }

    private fun calculatePrice(mlValue: Double, price: Double): Double {
        val literDividedByMl = 1000.0 / mlValue
        return literDividedByMl * price
    }

    private fun displayResults() {

        val firstLiterPrice =  calculatePrice(firstMlValue, binding.firstPriceEditText.toPrice())
        binding.resultFirstTextView.text =
            String.format("O preço do litro é: R$ %.2f ", firstLiterPrice)

        val secondLiterPrice =  calculatePrice(secondMlValue, binding.secondPriceEditText.toPrice())
        binding.resultSecondTextView.text =
            String.format("O preço do litro é: R$ %.2f ", secondLiterPrice)

        showCheaperOption(firstLiterPrice,secondLiterPrice)
    }

    private fun showCheaperOption(firstLiterPrice: Double, secondLiterPrice: Double) {
        when {
            firstLiterPrice > secondLiterPrice -> binding.resultFinalTextView.text =
                getString(R.string.better_buy_second)
            firstLiterPrice == secondLiterPrice -> binding.resultFinalTextView.text =
                getString(R.string.equal_prices)
            else -> binding.resultFinalTextView.text = getString(R.string.better_buy_first)
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
        firstRadioGroupSelected = false
        secondRadioGroupSelected = false
        firstMlValue = 0.0
        secondMlValue = 0.0
    }
}