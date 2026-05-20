package com.promptly.pref.domain.repository

interface ShortcutRepository {
    suspend fun getAddPromptShortcut(): String
    suspend fun saveAddPromptShortcut(shortcut: String)
    suspend fun getSearchPromptShortcut(): String
    suspend fun saveSearchPromptShortcut(shortcut: String)
}