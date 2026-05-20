package com.promptly.db.repository

import com.promptly.db.dao.PrefDao
import com.promptly.db.entity.PrefEntity
import com.promptly.pref.domain.repository.ShortcutRepository

class ShortcutRepositoryImpl(
    private val prefDao: PrefDao
) : ShortcutRepository {

    override suspend fun getAddPromptShortcut(): String {
        return prefDao.getPref("add_prompt_shortcut")?.value ?: "Ctrl+N"
    }

    override suspend fun saveAddPromptShortcut(shortcut: String) {
        prefDao.insertPref(PrefEntity("add_prompt_shortcut", shortcut))
    }

    override suspend fun getSearchPromptShortcut(): String {
        return prefDao.getPref("search_prompt_shortcut")?.value ?: "Ctrl+S"
    }

    override suspend fun saveSearchPromptShortcut(shortcut: String) {
        prefDao.insertPref(PrefEntity("search_prompt_shortcut", shortcut))
    }
}