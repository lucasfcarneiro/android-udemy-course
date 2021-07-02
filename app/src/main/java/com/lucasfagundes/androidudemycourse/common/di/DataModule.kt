package com.lucasfagundes.androidudemycourse.common.di

import com.lucasfagundes.androidudemycourse.common.data.SharedPreferenceHelper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {
    single { SharedPreferenceHelper(androidApplication()) }
}