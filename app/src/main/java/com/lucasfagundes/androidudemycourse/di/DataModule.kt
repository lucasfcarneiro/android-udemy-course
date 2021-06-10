package com.lucasfagundes.androidudemycourse.di

import com.lucasfagundes.androidudemycourse.data.SharedPreferenceHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {
    single { SharedPreferenceHelper(androidApplication()) }
}

