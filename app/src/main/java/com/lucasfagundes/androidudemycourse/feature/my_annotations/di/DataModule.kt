package com.lucasfagundes.androidudemycourse.feature.my_annotations.di

import com.lucasfagundes.androidudemycourse.feature.my_annotations.data.SharedPreferenceHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {
    single { SharedPreferenceHelper(androidApplication()) }
}