package com.afs.tutrd.presentation.home.view.calendar

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.afs.tutrd.presentation.home.stateholder.rememberTutrdCalendarState
import com.kizitonwose.calendar.compose.CalendarState
import com.kizitonwose.calendar.compose.HorizontalCalendar
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.daysOfWeek
import java.time.DayOfWeek
import java.time.LocalDate

@Composable
fun Calendar(
    selectedDate: LocalDate,
    calendarState: CalendarState,
    changeSelectedDate: (clickedDate: CalendarDay) -> Unit
) {
    val TAG = "calendar"

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
    ) {
        DaysOfWeekTitle(daysOfWeek(firstDayOfWeek = DayOfWeek.SUNDAY))
        HorizontalCalendar(
            state = calendarState,
            dayContent = {
                Day(
                    day = it,
                    clickedDate = selectedDate,
                    onDateClick = { clickedDate -> changeSelectedDate(clickedDate) },
                ) },
            calendarScrollPaged = true, //차이점 잘 모르겠음
        )
    }
}