package org.nunocky.myapplication.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.nunocky.myapplication.ui.theme.MyApplicationTheme


@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(modifier = Modifier.fillMaxSize(), floatingActionButton = {
        FloatingActionButton(onClick = {
            viewModel.increment()
        }) {
            Icon(Icons.Filled.Add, "Increment")
        }
    }) { innerPadding ->
        Text(
            text = "${uiState.value.count} times clicked", modifier = modifier.padding(innerPadding)
        )
    }
}

class MockViewModel : MainViewModel() {
    init {
        _uiState.value = MainScreenUiState(count = 99)
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun MainScreenPreview() {
    val mockViewModel = MockViewModel()
    MyApplicationTheme {
        MainScreen(viewModel = mockViewModel)
    }
}