package com.afs.tutrd.presentation.home.viewmodel

import androidx.compose.runtime.Composable
import com.afs.tutrd.common.base.BaseViewModel
import com.afs.tutrd.presentation.home.contract.HomeIntent
import com.afs.tutrd.presentation.home.contract.HomeSideEffect
import com.afs.tutrd.presentation.home.contract.HomeState
import com.kizitonwose.calendar.compose.CalendarState
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.DayPosition
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import java.time.YearMonth
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<HomeState, HomeIntent, HomeSideEffect>(
    initialState = HomeState.init()
) {
    lateinit var calendarState: CalendarState

    override fun handleIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.ChangeDate -> { changeDate(intent.clickedDate) }
            is HomeIntent.ChangeMonth -> {}
        }
    }
    private fun changeDate(clickedDate: CalendarDay) {
        if (uiState.value.dateSelection != clickedDate.date) {
            reduce { copy(dateSelection = clickedDate.date) }
            if (clickedDate.position == DayPosition.InDate) {
                postSideEffect { HomeSideEffect.NavigateToPrevMonth }
            }
            else if (clickedDate.position == DayPosition.OutDate) {
                postSideEffect { HomeSideEffect.NavigateToNextMonth }
            }
        }

    }



}


