package com.afs.tutrd.presentation.home.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.afs.tutrd.component.scaffold.TutrdScaffold
import com.afs.tutrd.presentation.home.viewmodel.HomeViewModel
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.daysOfWeek
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import java.time.DayOfWeek
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import androidx.compose.material3.Button
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import com.afs.tutrd.common.extension.collectInLaunchedEffectWithLifecycle
import com.afs.tutrd.presentation.home.contract.HomeIntent
import com.afs.tutrd.presentation.home.contract.HomeSideEffect
import com.afs.tutrd.presentation.home.view.calendar.Calendar
import android.util.Log
import com.kizitonwose.calendar.core.yearMonth

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    //calendar states
//    val currentMonth = remember { YearMonth.now() }
    val startMonth = remember { uiState.dateSelection.yearMonth.minusMonths(100) } // Adjust as needed
    val endMonth = remember { uiState.dateSelection.yearMonth.plusMonths(100) } // Adjust as needed
    val firstDayOfWeek = remember { firstDayOfWeekFromLocale() } // Available from the library
    val calendarState = rememberCalendarState(
        startMonth = startMonth,
        endMonth = endMonth,
        firstVisibleMonth = uiState.dateSelection.yearMonth,
        firstDayOfWeek = firstDayOfWeek
    )

    val currentMonthFormatted = remember(calendarState.firstVisibleMonth.yearMonth) {
        calendarState.firstVisibleMonth.yearMonth.format(DateTimeFormatter.ofPattern("yyyy년 MM월"))
    }


    // Create a coroutine scope
//    val coroutineScope = rememberCoroutineScope()
//    val toNext = toNextMonth() {
//        calendarState.scrollToMonth((calendarState.firstVisibleMonth.yearMonth).plusMonths(1))
//    }

    TutrdScaffold(
        topBar = { HomeTopBar(title = currentMonthFormatted) {} }
    ) { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Calendar(
                    selectedDate = uiState.dateSelection,
                    calendarState = calendarState,
                    changeSelectedDate = { clickedDate -> viewModel.postIntent(HomeIntent.ChangeDate(clickedDate)) }
                )
                Text(
                    uiState.dateSelection.toString(),
                    modifier = Modifier,
                )
            }
        }
    }

    viewModel.sideEffect.collectInLaunchedEffectWithLifecycle { sideEffect ->
        when(sideEffect) {
            is HomeSideEffect.NavigateToPrevMonth -> { calendarState.scrollToMonth(uiState.dateSelection.yearMonth) }
            is HomeSideEffect.NavigateToNextMonth -> { calendarState.scrollToMonth(uiState.dateSelection.yearMonth) }
        }
    }

}