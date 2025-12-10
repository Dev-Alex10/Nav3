package com.example.nav3.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nav3.viewmodels.TodoDetailViewModel

@Composable
fun TodoDetailScreen(
    todo: String,
    viewModel: TodoDetailViewModel = viewModel { //needs to be here so the viewModel lifecycle is "bundled"
        TodoDetailViewModel(todo)
    },
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary),
        contentAlignment = Alignment.Center
    ) {
        Text(text = todo)
    }

}