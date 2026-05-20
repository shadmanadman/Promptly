package com.promptly.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.promptly.db.entity.PrefEntity

@Dao
interface PrefDao {
    @Query("SELECT * FROM prefs WHERE `key` = :key")
    suspend fun getPref(key: String): PrefEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPref(pref: PrefEntity)
}