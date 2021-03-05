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
        binding = FragmentBeerValuesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.calcButton.setOnClickListener {
            setResultsAtScreen()
            hideKeyboard()
        }

        binding.cleanButton.setOnClickListener { cleanFields() }
    }

    private fun setResultsAtScreen(){
        val firstRadioButtonValue = checkRadioButtonSelection(binding.firstRadioGroup)
        val secondRadioButtonValue = checkRadioButtonSelection(binding.secondRadioGroup)

        val firstLiterPrice = calculatePrice(firstRadioButtonValue,binding.firstPriceEditText)
        val secondLiterPrice = calculatePrice(secondRadioButtonValue,binding.secondPriceEditText)

        binding.resultFirstTextView.text = getString(R.string.liter_price, firstLiterPrice.toString().format("%.2f"))
        binding.resultSecondTextView.text =  getString(R.string.liter_price, secondLiterPrice.toString().format("%.2f"))
        //"O preço do litro é: ${String.format("%.2f", secondLiterPrice)} reais"
        when {
            firstLiterPrice > secondLiterPrice -> {
                binding.resultFinalTextView.text =  getString(R.string.better_second_option, secondRadioButtonValue.toString())
                //"Melhor comprar a segunda opção: ${secondRadioButtonValue.toInt()} ML"
            }
            firstLiterPrice == secondLiterPrice -> {
                binding.resultFinalTextView.text = getString(R.string.equal_prices)
            }
            else -> binding.resultFinalTextView.text = getString(R.string.better_first_option,firstRadioButtonValue.toString())
        }
    }

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
    private fun cleanFields (){
        binding.firstPriceEditText.setText("")
        binding.secondPriceEditText.setText("")
        binding.resultFirstTextView.text = ""
        binding.resultSecondTextView.text = ""
        binding.resultFinalTextView.text = ""
        binding.secondRadioGroup.clearCheck()
        binding.firstRadioGroup.clearCheck()
    }
}