package com.lucasfagundes.androidudemycourse.feature.beer_values

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import com.google.android.material.textfield.TextInputEditText
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentBeerValuesBinding

class BeerValuesFragment : Fragment() {

    var valor = 0
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
        binding.cleanButton.setOnClickListener { cleanFields() }

        binding.calcButton.setOnClickListener {
            val radioMlValue1 = checkRadioValue(binding.firstRadioGroup)
            val radioMlValue2 = checkRadioValue(binding.secondRadioGroup)

            if(radioMlValue1 == 0 && radioMlValue2 == 0){ //se nao clicou no radio faz
                val enteredValue = checkTextEditValue(binding.firstMLEditText)
                val enteredValue2 = checkTextEditValue(binding.secondMLEditText)

                val literPrice = calculatePrice(enteredValue,binding.firstPriceEditText)
                val literPrice2 =calculatePrice(enteredValue2,binding.secondPriceEditText)
                displayResults(literPrice,literPrice2)

            }else{ // se clicou radio faz
                val literPrice = calculatePrice(radioMlValue1,binding.firstPriceEditText)
                val literPrice2 = calculatePrice(radioMlValue2, binding.secondPriceEditText)
                displayResults(literPrice,literPrice2)
            }
        }
    }

    private fun checkTextEditValue(textInputEditText:TextInputEditText): Int {
        //tratar se tiver vazio
        return textInputEditText.text.toString().toInt()
    }

    private fun displayResults(qtd: Double, qtd2: Double) {
        binding.resultFirstTextView.text = String.format("%.2f", qtd)
        binding.resultSecondTextView.text = String.format("%.2f", qtd2)
    }

    private fun checkRadioValue(radio: RadioGroup): Int {

        return when (radio.checkedRadioButtonId) {
            R.id.Ml250Radio, R.id.Ml250Radio2 -> 250
            R.id.Ml350Radio, R.id.Ml350Radio2 -> 350
            R.id.Ml473Radio, R.id.Ml473Radio2 -> 473
            R.id.Ml600Radio, R.id.Ml600Radio2 -> 600
            else -> 0
        }
    }

    private fun calculatePrice(canMlValue: Int, canPrice: TextInputEditText): Double {
        val numberOfCans:Double = 1000.0 / canMlValue
        return numberOfCans * canPrice.text.toString().toDouble()
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