package com.promptly.db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.promptly.db.dao.PromptDao
import com.promptly.db.dao.PrefDao
import com.promptly.db.entity.PromptEntity
import com.promptly.db.entity.PrefEntity

@Database(entities = [PromptEntity::class, PrefEntity::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun promptDao(): PromptDao
    abstract fun prefDao(): PrefDao
}

// The compiler generates an implementation of this class
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase {
    return builder
        .setDriver(androidx.sqlite.driver.bundled.BundledSQLiteDriver())
        .build()
}