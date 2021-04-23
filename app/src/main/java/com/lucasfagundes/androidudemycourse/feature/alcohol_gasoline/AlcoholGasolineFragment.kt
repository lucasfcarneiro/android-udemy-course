package com.lucasfagundes.androidudemycourse.feature.alcohol_gasoline

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentAlcoholGasolineBinding
import com.lucasfagundes.androidudemycourse.utils.hideKeyboard

class AlcoholGasolineFragment : Fragment() {

    private lateinit var binding: FragmentAlcoholGasolineBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlcoholGasolineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calcButton.setOnClickListener {
            getPrices()
        }
        binding.cleaTextView.setOnClickListener { cleanFields() }
    }

    private fun getPrices() {
        val alcoholPrice = binding.alcoholInputText.text.toString()
        val gasolinePrice = binding.gasolineInputText.text.toString()

        val fieldValidated = validateFields(alcoholPrice, gasolinePrice)

        if (fieldValidated) {
            val division = alcoholPrice.toDouble() / gasolinePrice.toDouble()
            if (division <= 0.7) {
                binding.resultTextView.text = getString(R.string.better_alcohol)
            } else {
                binding.resultTextView.text = getString(R.string.better_gasoline)
            }
            binding.percentTextView.text = getString(R.string.relation_price_info, division.toString())
        } else {
            binding.resultTextView.text = getString(R.string.empty_field)
        }
    }

    private fun validateFields(alcoholInputText: String, gasolineInputText: String): Boolean {
        var isValid = true

        if (alcoholInputText.isBlank()) {
            isValid = false
        } else if (gasolineInputText.isBlank()) {
            isValid = false
        }
        return isValid
    }

    private fun cleanFields() {
        binding.alcoholInputText.setText("")
        binding.gasolineInputText.setText("")
        binding.resultTextView.text = ""
        binding.percentTextView.text = ""
    }
}