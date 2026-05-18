package com.promptly.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.promptly.hub.domain.model.Prompt

@Entity(tableName = "prompts")
data class PromptEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val appName: String,
    val llmName: String,
    val prompt: String,
    val savePeriod: String
)

fun PromptEntity.toDomain() = Prompt(
    id = id,
    appName = appName,
    llmName = llmName,
    prompt = prompt,
    savePeriod = savePeriod
)

fun Prompt.toEntity() = PromptEntity(
    id = id,
    appName = appName,
    llmName = llmName,
    prompt = prompt,
    savePeriod = savePeriod
)