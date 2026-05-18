package com.promptly.pref.di

import com.promptly.pref.domain.usecase.GetShortcutsUseCase
import com.promptly.pref.domain.usecase.SaveShortcutUseCase
import com.promptly.pref.presentation.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val prefModule = module {
    factory { GetShortcutsUseCase(get()) }
    factory { SaveShortcutUseCase(get()) }
    viewModel { HomeViewModel(get(), get()) }
}