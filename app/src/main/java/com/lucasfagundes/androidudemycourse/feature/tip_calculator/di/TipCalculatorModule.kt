package com.lucasfagundes.androidudemycourse.feature.tip_calculator.di

import com.lucasfagundes.androidudemycourse.feature.tip_calculator.TipCalculatorViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val tipCalculatorModule = module {
    viewModel { TipCalculatorViewModel() }
}