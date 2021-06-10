package com.lucasfagundes.androidudemycourse.app

import android.app.Application
import com.lucasfagundes.androidudemycourse.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                dataModule
            ).androidContext(applicationContext)
        }
    }
}