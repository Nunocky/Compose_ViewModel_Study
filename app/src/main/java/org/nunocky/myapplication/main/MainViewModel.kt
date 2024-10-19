package org.nunocky.myapplication.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun increment() {
        _uiState.value = _uiState.value.copy(count = _uiState.value.count + 1)
    }
}