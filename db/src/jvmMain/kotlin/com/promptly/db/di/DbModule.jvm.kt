package com.promptly.db.di

import androidx.room.Room
import com.promptly.db.AppDatabase
import com.promptly.db.getRoomDatabase
import com.promptly.db.repository.PromptRepositoryImpl
import com.promptly.hub.domain.repository.PromptRepository
import org.koin.dsl.module
import java.io.File

val dbModule = module {
    single<AppDatabase> {
        val dbFile = File(System.getProperty("user.home"), "promptly.db")
        val builder = Room.databaseBuilder<AppDatabase>(
            name = dbFile.absolutePath,
        )
        getRoomDatabase(builder)
    }
    single { get<AppDatabase>().promptDao() }
    single<PromptRepository> { PromptRepositoryImpl(get()) }
}