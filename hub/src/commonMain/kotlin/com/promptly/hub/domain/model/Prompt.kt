package com.promptly.hub.domain.model

data class Prompt(
    val id: Long = 0,
    val appName: String,
    val llmName: String,
    val prompt: String,
    val savePeriod: String
)