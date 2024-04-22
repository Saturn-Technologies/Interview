package com.example.saturninterview.data

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier


@Composable
fun DogsView() {
    val viewModel = ExampleViewModel.defaultViewModel
    val response = viewModel.response.collectAsState().value

    LaunchedEffect(UInt) {
        viewModel.getData()
    }

    Column(modifier = Modifier
        .fillMaxSize()) {
        Text(text = response)
    }
}
