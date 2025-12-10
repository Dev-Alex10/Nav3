package com.example.nav3

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.nav3.navigation.NavigationRoot
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        NavigationRoot()
    }
}