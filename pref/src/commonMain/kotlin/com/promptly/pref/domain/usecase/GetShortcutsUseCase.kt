package com.promptly.pref.domain.usecase

import com.promptly.pref.domain.repository.ShortcutRepository

class GetShortcutsUseCase(private val repository: ShortcutRepository) {
    suspend operator fun invoke() = Pair(
        repository.getAddPromptShortcut(),
        repository.getSearchPromptShortcut()
    )
}