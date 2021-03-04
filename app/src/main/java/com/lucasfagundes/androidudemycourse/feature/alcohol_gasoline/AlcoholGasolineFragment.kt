package com.lucasfagundes.androidudemycourse.feature.alcohol_gasoline

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentAlcoholGasolineBinding

class AlcoholGasolineFragment : Fragment() {

    private lateinit var binding: FragmentAlcoholGasolineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.calcButton.setOnClickListener { getPrices() }
        binding.cleaTextView.setOnClickListener { cleanFields() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlcoholGasolineBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun getPrices() {
        val alcoholPrice = binding.alcoholInputText.text.toString().toDouble()
        val gasolinePrice = binding.gasolineInputText.text.toString().toDouble()

        val fieldValidated = validateFields(alcoholPrice, gasolinePrice)

        if (fieldValidated) {
            val division = alcoholPrice / gasolinePrice
            if (division <= 0.7) {
                binding.resultTextView.text = getString(R.string.better_alcohol)
            } else {
                binding.resultTextView.text = getString(R.string.better_gasoline)
            }
            binding.percentTextView.text =
                getString(R.string.relation_price_info, division.toString())
            //"$division é o preço do alcool em relação a gasolina"
        }
    }

    private fun validateFields(x: Double, y: Double): Boolean {
        var isValid = true

        if (x.equals("")) {
            isValid = false
        } else if (y.equals("")) {
            isValid = false
        }
        return isValid
    }

    private fun cleanFields() {
        binding.alcoholInputText.setText("")
        binding.alcoholInputText.setText("")
        binding.resultTextView.text = ""
        binding.percentTextView.text = ""
    }

}