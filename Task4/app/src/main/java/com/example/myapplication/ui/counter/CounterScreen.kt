package com.example.myapplication.ui.counter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CounterScreen(
    counterViewModel: CounterViewModel = viewModel()
) {
    Column(modifier = Modifier.statusBarsPadding()) {
        Text(
            text = "Счётчик: ${counterViewModel.counter.value}"
        )

        Button(
            onClick = {
                counterViewModel.incrementCounter()
            }
        ) {
            Text(text = "Увеличить")
        }
    }
}