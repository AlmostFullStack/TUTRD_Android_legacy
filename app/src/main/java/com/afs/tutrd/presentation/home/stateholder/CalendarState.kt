package com.afs.tutrd.presentation.home.stateholder

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import com.kizitonwose.calendar.compose.CalendarLayoutInfo
import com.kizitonwose.calendar.compose.CalendarState
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.CalendarMonth
import com.kizitonwose.calendar.core.Week
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import java.time.YearMonth


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


/**
 * 스크롤 감지하고 해당 월 반환
 *
 * @param state HorizontalCalendar 의 상태인 [CalendarState]
 * @param viewportPercent 넘어오는 정도 default : 50f
 *
 * @return 해당 주 [Week]
 */
@Composable
internal fun rememberFirstMostVisibleMonth(
    state: CalendarState,
    viewportPercent: Float = 50f,
    collect: (CalendarMonth) -> Unit
): CalendarMonth {
    val visibleMonth = remember(state) { mutableStateOf(state.firstVisibleMonth) }
    LaunchedEffect(state) {
        snapshotFlow { state.layoutInfo.firstMostVisibleMonth(viewportPercent) }
            .distinctUntilChanged()
            .filterNotNull()
            .collect { month ->
                visibleMonth.value = month
                collect(month)
            }
    }
    return visibleMonth.value
}

private fun CalendarLayoutInfo.firstMostVisibleMonth(viewportPercent: Float = 50f): CalendarMonth? {
    return if (visibleMonthsInfo.isEmpty()) {
        null
    } else {
        val viewportSize = (viewportEndOffset + viewportStartOffset) * viewportPercent / 100f
        visibleMonthsInfo.firstOrNull { itemInfo ->
            if (itemInfo.offset < 0) {
                itemInfo.offset + itemInfo.size >= viewportSize
            } else {
                itemInfo.size - itemInfo.offset >= viewportSize
            }
        }?.month
    }
}