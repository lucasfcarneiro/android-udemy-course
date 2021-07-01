package com.lucasfagundes.androidudemycourse.feature.alcohol_gasoline.di

import com.lucasfagundes.androidudemycourse.feature.alcohol_gasoline.AlcoholGasolineViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val alcoholGasolineModule = module {
    viewModel { AlcoholGasolineViewModel(get()) }
}