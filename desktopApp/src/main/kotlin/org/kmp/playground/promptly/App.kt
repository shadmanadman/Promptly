package org.kmp.playground.promptly

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.promptly.pref.presentation.home.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App(viewModel: HomeViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsState()
    
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Home Screen (Pref)")
            Text("Add Shortcut: ${state.addShortcut}")
            Text("Search Shortcut: ${state.searchShortcut}")
            
            Button(onClick = { /* Navigate to Search */ }) {
                Text("Search Popup (Scene)")
            }
            Button(onClick = { /* Navigate to Save */ }) {
                Text("Save Popup (Scene)")
            }
        }
    }
}