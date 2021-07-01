package com.lucasfagundes.androidudemycourse.feature.alcohol_gasoline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.fragment.app.Fragment
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentAlcoholGasolineBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewAlcoholGasolineFragment : Fragment() {

    private lateinit var binding: FragmentAlcoholGasolineBinding
    private val viewModel: AlcoholGasolineViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAlcoholGasolineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleButtonClick()
        handleObserver()
    }

    private fun handleButtonClick() {
        with(binding) {
            calcButton.setOnClickListener {
                viewModel.compareFuelPrices(
                    alcoholInputText.text.toString(),
                    gasolineInputText.text.toString()
                )
            }
            clearButton.setOnClickListener {
                clearFields()
            }
        }
    }

    private fun handleObserver() {
        val result = Observer<String> { result ->
            binding.resultTextView.text = result
        }
        viewModel.result.observe(viewLifecycleOwner, result)

        val comparison = Observer<String> { comparison ->
            binding.comparisonTextView.text = comparison
        }
        viewModel.comparison.observe(viewLifecycleOwner, comparison)
    }

    private fun clearFields() {
        with(binding) {
            alcoholInputText.setText(getString(R.string.empty))
            gasolineInputText.setText(getString(R.string.empty))
            resultTextView.text = getString(R.string.empty)
            comparisonTextView.text = getString(R.string.empty)
        }
    }
}