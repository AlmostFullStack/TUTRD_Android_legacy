package com.afs.tutrd.presentation.home.stateholder

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import java.time.YearMonth
import com.kizitonwose.calendar.compose.CalendarState
import com.kizitonwose.calendar.compose.rememberCalendarState



class TutrdCalendarState(
    val selectedDate: SelectedDateState,
    val calendarState: CalendarState
) {
    fun scrollToNextMonth() {

    }

    fun scrollToPrevMonth() {

    }
}

@Composable
fun rememberTutrdCalendarState(
    selectedDate: SelectedDateState = SelectedDateState.rememberSelectedDateState(),
    calendarState: CalendarState = rememberCalendarState(
        startMonth = YearMonth.now().minusMonths(100),
        endMonth = YearMonth.now().minusMonths(100),
        firstVisibleMonth = YearMonth.now(),
        firstDayOfWeek = firstDayOfWeekFromLocale(),
    )
    ) = remember(selectedDate, calendarState) {
    TutrdCalendarState(selectedDate, calendarState)
}
