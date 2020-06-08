package com.djair.chucknorris.di.module

import com.djair.chucknorris.data.repository.JokeRepositoryImpl
import com.djair.chucknorris.domain.repository.JokeRepository
import com.djair.chucknorris.presentation.home.HomeViewModel
import com.djair.chucknorris.presentation.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val SplashModule = module {
    viewModel {
        SplashViewModel()
    }
}

val HomeModule = module {
    viewModel {
        HomeViewModel(get())
    }

    single<JokeRepository> {
        JokeRepositoryImpl(get())
    }
}