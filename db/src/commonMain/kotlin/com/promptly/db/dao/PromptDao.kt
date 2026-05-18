package com.promptly.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.promptly.db.entity.PromptEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PromptDao {
    @Query("SELECT * FROM prompts")
    fun getAllPrompts(): Flow<List<PromptEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPrompt(prompt: PromptEntity)

    @Delete
    suspend fun deletePrompt(prompt: PromptEntity)
}