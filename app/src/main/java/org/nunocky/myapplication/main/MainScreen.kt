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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.nunocky.myapplication.ui.theme.MyApplicationTheme


@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: MainViewModel = viewModel()
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

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun MainScreenPreview() {
    MyApplicationTheme {
        MainScreen()
    }
}