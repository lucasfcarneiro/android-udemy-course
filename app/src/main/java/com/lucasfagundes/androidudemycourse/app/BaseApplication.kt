package com.lucasfagundes.androidudemycourse.app

import android.app.Application
import com.lucasfagundes.androidudemycourse.feature.alcohol_gasoline.di.alcoholGasolineModule
import com.lucasfagundes.androidudemycourse.common.di.dataModule
import com.lucasfagundes.androidudemycourse.feature.my_annotations.di.myAnnotationsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    dataModule,
                    myAnnotationsModule,
                    alcoholGasolineModule
                )
            ).androidContext(applicationContext)
        }
    }
}