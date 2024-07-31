package com.afs.tutrd.presentation.home.contract

import com.afs.tutrd.common.base.UiIntent
import com.kizitonwose.calendar.core.CalendarDay
import java.time.LocalDate

sealed class HomeIntent:UiIntent() {
    data class ChangeDate(val clickedDate: CalendarDay): HomeIntent()
    data class ChangeMonth(val clickedDate: LocalDate): HomeIntent()
}