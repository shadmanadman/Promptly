package com.promptly.hub.presentation.search

import com.promptly.hub.domain.model.Prompt

data class SearchState(
    val query: String = "",
    val results: List<Prompt> = emptyList(),
    val isLoading: Boolean = false
)

sealed interface SearchIntent {
    data class UpdateQuery(val query: String) : SearchIntent
    data object ClearSearch : SearchIntent
}