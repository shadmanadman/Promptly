package com.promptly.hub.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.promptly.hub.domain.usecase.GetPromptsUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getPromptsUseCase: GetPromptsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SearchState())
    val state = _state.asStateFlow()

    fun handleIntent(intent: SearchIntent) {
        when (intent) {
            is SearchIntent.UpdateQuery -> updateQuery(intent.query)
            SearchIntent.ClearSearch -> _state.update { it.copy(query = "", results = emptyList()) }
        }
    }

    private fun updateQuery(query: String) {
        _state.update { it.copy(query = query) }
        if (query.isBlank()) {
            _state.update { it.copy(results = emptyList()) }
            return
        }
        
        viewModelScope.launch {
            getPromptsUseCase().collect { allPrompts ->
                val filtered = allPrompts.filter { 
                    it.appName.contains(query, ignoreCase = true) || 
                    it.prompt.contains(query, ignoreCase = true) 
                }
                _state.update { it.copy(results = filtered) }
            }
        }
    }
}