package com.promptly.db.repository

import com.promptly.db.dao.PromptDao
import com.promptly.db.entity.toDomain
import com.promptly.db.entity.toEntity
import com.promptly.hub.domain.model.Prompt
import com.promptly.hub.domain.repository.PromptRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PromptRepositoryImpl(
    private val promptDao: PromptDao
) : PromptRepository {
    override fun getPrompts(): Flow<List<Prompt>> {
        return promptDao.getAllPrompts().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun insertPrompt(prompt: Prompt) {
         promptDao.insertPrompt(prompt.toEntity())
    }

    override suspend fun deletePrompt(prompt: Prompt) {
        promptDao.deletePrompt(prompt.toEntity())
    }
}