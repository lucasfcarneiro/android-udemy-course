package com.lucasfagundes.androidudemycourse.feature.tip_calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.lifecycle.Observer
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentTipCalculatorBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class TipCalculatorFragment : Fragment() {

    private lateinit var billValue: String
    private var percentage = 0.0
    private lateinit var binding: FragmentTipCalculatorBinding
    private val viewModel: TipCalculatorViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTipCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        seekBarHandler()
        handleObserver()
    }

    private fun setupView() {
        binding.textViewTipValue.text = getString(R.string.value_text)
        binding.textViewTotalValue.text = getString(R.string.value_text)
        binding.textEditBillValue.hint =
            "${getString(R.string.hint_bill_text)} ${getString(R.string.hint_bill_value)}"
    }

    private fun seekBarHandler() {
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekBar.let {
                    binding.textViewPorcentage.text =
                        getString(R.string.percent, progress.toString())
                }
                billValue = binding.textEditBillValue.text.toString()
                percentage = progress.toDouble()
                if (billValue.isNotBlank()) {
                    viewModel.calculateTip()
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if (billValue.isBlank()) {
                    Toast.makeText(context, getString(R.string.hint_bill_text), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }

    private fun handleObserver() {
        val percentage = Observer<Double>{}
        viewModel.percentage.observe(viewLifecycleOwner, { percentage })
        val billValue = Observer<Double>{}
        viewModel.billvalue.observe(viewLifecycleOwner, { billValue })
    }


    private fun calculateTip(percentage: Double) {

        val tip = billValue.toDouble() * (percentage / 100)
        val total = billValue.toDouble() + tip

        binding.textViewTipValue.text =
            getString(R.string.money, String.format("%.2f", tip))
        binding.textViewTotalValue.text =
            getString(R.string.money, String.format("%.2f", total))
    }
}