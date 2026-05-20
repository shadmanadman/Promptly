package com.promptly.pref.presentation.home

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsState()

    val infiniteTransition = rememberInfiniteTransition()
    val animatedColor by infiniteTransition.animateColor(
        initialValue = MaterialTheme.colorScheme.primary,
        targetValue = MaterialTheme.colorScheme.tertiary,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Promptly",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = animatedColor,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        ShortcutOption(
            label = "Search Shortcut",
            shortcut = state.searchShortcut,
        ) { viewModel.handleIntent(HomeIntent.UpdateSearchShortcut(it)) }

        Spacer(modifier = Modifier.height(16.dp))

        ShortcutOption(
            label = "Add Prompt Shortcut",
            shortcut = state.addShortcut,
        ) { viewModel.handleIntent(HomeIntent.UpdateAddShortcut(it)) }
    }
}

@Composable
fun ShortcutOption(
    label: String,
    shortcut: String,
    onShortcutChanged: (String) -> Unit
) {
    var text by remember(shortcut) { mutableStateOf(shortcut) }

    OutlinedTextField(
        value = text,
        onValueChange = { 
            text = it
            onShortcutChanged(it)
        },
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(0.6f),
        singleLine = true
    )
}