package com.lucasfagundes.androidudemycourse.di

import com.lucasfagundes.androidudemycourse.feature.my_annotations.MyAnnotationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        MyAnnotationViewModel(
            sharedPreferenceHelper = get()
        )
    }
}