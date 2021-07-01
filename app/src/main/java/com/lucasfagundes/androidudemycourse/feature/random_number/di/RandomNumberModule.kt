package com.lucasfagundes.androidudemycourse.feature.random_number.di

import com.lucasfagundes.androidudemycourse.feature.random_number.RandomNumberViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val randomNumberModule = module {
    viewModel { RandomNumberViewModel() }
}