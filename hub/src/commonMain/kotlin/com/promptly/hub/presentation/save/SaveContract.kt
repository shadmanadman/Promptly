package com.promptly.hub.presentation.save

data class SaveState(
    val appName: String = "",
    val llmName: String = "",
    val prompt: String = "",
    val savePeriod: String = "Daily",
    val isSaving: Boolean = false,
    val isSaved: Boolean = false
)

sealed interface SaveIntent {
    data class UpdateAppName(val name: String) : SaveIntent
    data class UpdateLlmName(val name: String) : SaveIntent
    data class UpdatePrompt(val text: String) : SaveIntent
    data class UpdateSavePeriod(val period: String) : SaveIntent
    data object SavePrompt : SaveIntent
}