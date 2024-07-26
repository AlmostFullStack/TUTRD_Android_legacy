package com.afs.tutrd.presentation.home.contract

import com.afs.tutrd.common.base.UiIntent
import java.time.LocalDate

sealed class HomeIntent:UiIntent() {
    data class ChangeDate(val clickedDate: LocalDate): HomeIntent()
    data class ChangeMonth(val clickedDate: LocalDate): HomeIntent()
}