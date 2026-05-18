package com.promptly.hub.domain.usecase

import com.promptly.hub.domain.model.Prompt
import com.promptly.hub.domain.repository.PromptRepository

class InsertPromptUseCase(private val repository: PromptRepository) {
    suspend operator fun invoke(prompt: Prompt) = repository.insertPrompt(prompt)
}