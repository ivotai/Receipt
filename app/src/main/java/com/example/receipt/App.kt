package com.example.receipt

import androidx.multidex.MultiDexApplication
import com.example.receipt.module.appModule
import com.example.receipt.module.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule, networkModule)
        }
    }

}


