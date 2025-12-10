package com.example.nav3.auth.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nav3.auth.viewmodels.LoginViewModel
import com.example.nav3.auth.viewmodels.SharedAuthViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    sharedAuthViewModel: SharedAuthViewModel,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val localCounter by viewModel.counter.collectAsState()
    val sharedCounter by sharedAuthViewModel.counter.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = sharedAuthViewModel::bump
        ) {
            Text("Shared Counter: $sharedCounter")
        }

        Button(
            onClick = viewModel::bump
        ) {
            Text("Local Counter: $localCounter")
        }

        Button(
            onClick = onLoginClick
        ) {
            Text("Login")
        }

        Button(
            onClick = onRegisterClick
        ) {
            Text("Register")
        }

    }

}