package com.example.composepractice

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class WellnessTask(
    val id: Int, val label: String, private var initialChecked: Boolean = false
) {
    var checked by mutableStateOf(initialChecked)
}
