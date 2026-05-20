package com.promptly.hub.di

import com.promptly.hub.domain.usecase.GetPromptsUseCase
import com.promptly.hub.domain.usecase.InsertPromptUseCase
import com.promptly.hub.presentation.save.SaveViewModel
import com.promptly.hub.presentation.search.SearchViewModel
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModel

val hubModule = module {
    factory { GetPromptsUseCase(get()) }
    factory { InsertPromptUseCase(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { SaveViewModel(get()) }
}