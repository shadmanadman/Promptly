package com.promptly.pref.domain.usecase

import com.promptly.pref.domain.repository.ShortcutRepository

class SaveShortcutUseCase(private val repository: ShortcutRepository) {
    suspend fun saveAddShortcut(shortcut: String) = repository.saveAddPromptShortcut(shortcut)
    suspend fun saveSearchShortcut(shortcut: String) = repository.saveSearchPromptShortcut(shortcut)
}