package com.example.myapplication.ui.counter

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    val counter = mutableIntStateOf(0)

    fun incrementCounter() {
        counter.value += 1
    }
}