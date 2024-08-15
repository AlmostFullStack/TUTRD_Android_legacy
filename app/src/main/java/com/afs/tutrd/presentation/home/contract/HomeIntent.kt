package com.afs.tutrd.presentation.home.contract

import com.afs.tutrd.common.base.UiIntent
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.CalendarMonth

sealed class HomeIntent:UiIntent() {
    data class ChangeDate(val clickedDate: CalendarDay): HomeIntent()
    data class ChangeMonth(val month: CalendarMonth): HomeIntent()
}