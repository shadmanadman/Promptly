package com.promptly.hub.presentation.save

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.promptly.hub.domain.model.Prompt
import com.promptly.hub.domain.usecase.InsertPromptUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SaveViewModel(
    private val insertPromptUseCase: InsertPromptUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SaveState())
    val state = _state.asStateFlow()

    fun handleIntent(intent: SaveIntent) {
        when (intent) {
            is SaveIntent.UpdateAppName -> _state.update { it.copy(appName = intent.name) }
            is SaveIntent.UpdateLlmName -> _state.update { it.copy(llmName = intent.name) }
            is SaveIntent.UpdatePrompt -> _state.update { it.copy(prompt = intent.text) }
            is SaveIntent.UpdateSavePeriod -> _state.update { it.copy(savePeriod = intent.period) }
            SaveIntent.SavePrompt -> savePrompt()
        }
    }

    private fun savePrompt() {
        val current = _state.value
        viewModelScope.launch {
            _state.update { it.copy(isSaving = true) }
            insertPromptUseCase(
                Prompt(
                    appName = current.appName,
                    llmName = current.llmName,
                    prompt = current.prompt,
                    savePeriod = current.savePeriod
                )
            )
            _state.update { it.copy(isSaving = false, isSaved = true) }
        }
    }
}