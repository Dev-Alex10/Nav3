package com.example.nav3.auth.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {
    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    fun bump() {
        _counter.value++
        println("LoginViewModel bumped")
    }

    override fun onCleared() {
        super.onCleared()
        println("LoginViewModel cleared")
    }
}