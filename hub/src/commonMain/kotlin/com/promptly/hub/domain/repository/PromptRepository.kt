package com.promptly.hub.domain.repository

import com.promptly.hub.domain.model.Prompt
import kotlinx.coroutines.flow.Flow

interface PromptRepository {
    fun getPrompts(): Flow<List<Prompt>>
    suspend fun insertPrompt(prompt: Prompt)
    suspend fun deletePrompt(prompt: Prompt)
}