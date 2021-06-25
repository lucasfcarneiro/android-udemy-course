package com.lucasfagundes.androidudemycourse.feature.alcohol_gasoline.data

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {
    single { TesteFuncoesHelper(androidApplication()) }
}