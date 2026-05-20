package com.promptly.pref.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.promptly.pref.domain.usecase.GetShortcutsUseCase
import com.promptly.pref.domain.usecase.SaveShortcutUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getShortcutsUseCase: GetShortcutsUseCase,
    private val saveShortcutUseCase: SaveShortcutUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        handleIntent(HomeIntent.LoadShortcuts)
    }

    fun handleIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.LoadShortcuts -> loadShortcuts()
            is HomeIntent.UpdateAddShortcut -> updateAddShortcut(intent.shortcut)
            is HomeIntent.UpdateSearchShortcut -> updateSearchShortcut(intent.shortcut)
        }
    }

    private fun loadShortcuts() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            val (add, search) = getShortcutsUseCase()
            _state.update { it.copy(addShortcut = add, searchShortcut = search, isLoading = false) }
        }
    }

    private fun updateAddShortcut(shortcut: String) {
        viewModelScope.launch {
            saveShortcutUseCase.saveAddShortcut(shortcut)
            _state.update { it.copy(addShortcut = shortcut) }
        }
    }

    private fun updateSearchShortcut(shortcut: String) {
        viewModelScope.launch {
            saveShortcutUseCase.saveSearchShortcut(shortcut)
            _state.update { it.copy(searchShortcut = shortcut) }
        }
    }
}