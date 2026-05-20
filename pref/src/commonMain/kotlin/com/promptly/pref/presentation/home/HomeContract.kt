package com.promptly.pref.presentation.home

data class HomeState(
    val addShortcut: String = "Ctrl+N",
    val searchShortcut: String = "Ctrl+S",
    val isLoading: Boolean = false
)

sealed interface HomeIntent {
    data object LoadShortcuts : HomeIntent
    data class UpdateAddShortcut(val shortcut: String) : HomeIntent
    data class UpdateSearchShortcut(val shortcut: String) : HomeIntent
}