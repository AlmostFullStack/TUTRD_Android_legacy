package com.afs.tutrd.presentation.home.contract

import com.afs.tutrd.common.base.UiState
import java.time.LocalDate

data class HomeState(
    val dateSelection: LocalDate,
    val monthSelection: LocalDate,
): UiState() {
    companion object {
        fun init() = HomeState(
            dateSelection = LocalDate.now(),
            monthSelection = LocalDate.now()
        )
    }
}