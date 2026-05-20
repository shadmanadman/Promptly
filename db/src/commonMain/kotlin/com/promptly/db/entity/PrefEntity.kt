package com.promptly.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prefs")
data class PrefEntity(
    @PrimaryKey val key: String,
    val value: String
)