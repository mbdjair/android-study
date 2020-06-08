package com.djair.chucknorris

import android.app.Application
import com.djair.chucknorris.di.module.HomeModule
import com.djair.chucknorris.di.module.NetworkModule
import com.djair.chucknorris.di.module.SplashModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(SplashModule, HomeModule, NetworkModule))
        }

    }
}