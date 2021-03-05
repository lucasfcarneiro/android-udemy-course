package com.lucasfagundes.androidudemycourse.feature.tip_calculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import com.lucasfagundes.androidudemycourse.R
import com.lucasfagundes.androidudemycourse.databinding.FragmentTipCalculatorBinding
import kotlin.math.roundToInt

private lateinit var billValue: String
private var percentage = 0.0

class TipCalculatorFragment : Fragment() {

    private lateinit var binding: FragmentTipCalculatorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTipCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        seekBarHandler()
    }

    private fun seekBarHandler() {

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                seekBar.let {
                    percentage = progress.toDouble()
                    binding.textViewPorcentage.text = "${percentage.roundToInt()}%"
                }
                billValue = binding.textEditBillValue.text.toString()
                calculateTip(percentage)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    private fun calculateTip(percentage: Double) {

        if (billValue.isBlank()) {

            val emptyBill =
                Toast.makeText(context, "Digite o valor da conta", Toast.LENGTH_LONG)
            emptyBill.show()

            binding.textViewTipValue.text = getString(R.string.value_text)
            binding.textViewTotalValue.text = getString(R.string.value_text)
        } else {

            val tip = billValue.toDouble() * (percentage / 100)
            val total = billValue.toDouble() + tip

            binding.textViewTipValue.text = getString(R.string.`R$`, tip.toString())
            binding.textViewTotalValue.text = getString(R.string.`R$`, total.toString())
        }
    }
}