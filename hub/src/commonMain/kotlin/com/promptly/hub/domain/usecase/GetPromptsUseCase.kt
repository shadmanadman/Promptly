package com.promptly.hub.domain.usecase

import com.promptly.hub.domain.repository.PromptRepository

class GetPromptsUseCase(private val repository: PromptRepository) {
    operator fun invoke() = repository.getPrompts()
}