package org.kmp.playground.promptly

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.promptly.db.di.dbModule
import com.promptly.hub.di.hubModule
import com.promptly.pref.di.prefModule
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(hubModule, dbModule, prefModule)
    }
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Promptly",
        ) {
            App()
        }
    }
}