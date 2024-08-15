package com.afs.tutrd.presentation.home.viewmodel

import com.afs.tutrd.common.base.BaseViewModel
import com.afs.tutrd.presentation.home.contract.HomeIntent
import com.afs.tutrd.presentation.home.contract.HomeSideEffect
import com.afs.tutrd.presentation.home.contract.HomeState
import com.kizitonwose.calendar.compose.CalendarState
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.CalendarMonth
import com.kizitonwose.calendar.core.DayPosition
import com.kizitonwose.calendar.core.atStartOfMonth
import com.kizitonwose.calendar.core.yearMonth
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<HomeState, HomeIntent, HomeSideEffect>(
    initialState = HomeState.init()
) {
    lateinit var calendarState: CalendarState

    override fun handleIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.ChangeDate -> { changeDate(intent.clickedDate) }
            is HomeIntent.ChangeMonth -> { changeMonth(intent.month) }
        }
    }
    private fun changeDate(clickedDate: CalendarDay) {
        if (uiState.value.dateSelection != clickedDate.date) {
            changeSelectionDate(clickedDate.date)
            if (clickedDate.position == DayPosition.InDate) {
                postSideEffect { HomeSideEffect.NavigateToPrevMonth }
            }
            else if (clickedDate.position == DayPosition.OutDate) {
                postSideEffect { HomeSideEffect.NavigateToNextMonth }
            }
        }

    }

    private fun changeMonth(month: CalendarMonth) {
        if (currentState.isFirstLaunched) {
            reduce { copy(isFirstLaunched = false) }
            return
        }
        if (currentState.dateSelection.yearMonth == month.yearMonth) return
        val startOfMonth = month.yearMonth.atStartOfMonth()
        changeSelectionDate(startOfMonth)
    }

    private fun changeSelectionDate(date: LocalDate) {
        reduce { copy(dateSelection = date) }
    }


}


