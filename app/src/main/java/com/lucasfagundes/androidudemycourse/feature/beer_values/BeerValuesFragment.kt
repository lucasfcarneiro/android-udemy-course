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
import com.lucasfagundes.androidudemycourse.feature.beer_values.utils.toPrice

class BeerValuesFragment : Fragment() {

    private var firstRadioGroupSelected = false
    private var secondRadioGroupSelected = false
    private var firstMlValue: Int? = null
    private var secondMlValue: Int? = null

    private lateinit var binding: FragmentBeerValuesBinding

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
            Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
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
            Toast.makeText(context, "Selecione as duas medidas", Toast.LENGTH_SHORT).show()
        }
        return isValid
    }

    private fun setRadioGroupSelected(radio: RadioGroup) {
        when (radio.id) {
            R.id.firstRadioGroup -> firstRadioGroupSelected = true
            R.id.secondRadioGroup -> secondRadioGroupSelected = true
        }
    }

    private fun setMlValue(radio: RadioGroup, mlValue: Int) {
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
                    setMlValue(radioGroup, 250)
                }
                R.id.Ml350Radio, R.id.Ml350Radio2 -> {
                    setRadioGroupSelected(radioGroup)
                    setMlValue(radioGroup, 350)
                }
                R.id.Ml473Radio, R.id.Ml473Radio2 -> {
                    setRadioGroupSelected(radioGroup)
                    setMlValue(radioGroup, 473)
                }
                R.id.Ml600Radio, R.id.Ml600Radio2 -> {
                    setRadioGroupSelected(radioGroup)
                    setMlValue(radioGroup, 600)
                }
            }
        }
    }

    private fun calculatePrice(mlValue: Int, price: Double): Double {
        val numberOfCans: Double = 1000.0 / mlValue
        return numberOfCans * price
    }

    private fun displayResults() {
        binding.resultFirstTextView.text = String.format("%.2f",
            firstMlValue?.let {
                calculatePrice(
                    it,
                    binding.firstPriceEditText.toPrice()
                )
            }
        )

        binding.resultSecondTextView.text = String.format("%.2f",
            secondMlValue?.let {
                calculatePrice(
                    it,
                    binding.secondPriceEditText.toPrice()
                )
            }
        )
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
        firstMlValue = null
        secondMlValue = null
    }
}


//"O preço do litro é: ${String.format("%.2f", secondLiterPrice)} reais"
//"Melhor comprar a segunda opção: ${secondRadioButtonValue.toInt()} ML"