package com.afs.tutrd.presentation.home.stateholder

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import java.time.LocalDate

class SelectedDateState private constructor() {
    var selectedDateState: LocalDate by mutableStateOf(LocalDate.now())
        private set

    companion object {
        @Composable
        fun rememberSelectedDateState(): SelectedDateState {
            return remember { SelectedDateState() }
        }
    }
}