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
import com.afs.tutrd.presentation.home.HomeViewModel
import com.afs.tutrd.presentation.home.contract.HomeIntent
import com.afs.tutrd.presentation.home.view.calendar.Day
import com.afs.tutrd.presentation.home.view.calendar.DaysOfWeekTitle
import com.kizitonwose.calendar.compose.HorizontalCalendar
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.daysOfWeek
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import java.time.DayOfWeek
import java.time.YearMonth
import java.time.format.DateTimeFormatter

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    //calendar states
    val currentMonth = remember { YearMonth.now() }
    val startMonth = remember { currentMonth.minusMonths(100) } // Adjust as needed
    val endMonth = remember { currentMonth.plusMonths(100) } // Adjust as needed
    val firstDayOfWeek = remember { firstDayOfWeekFromLocale() } // Available from the library
    val daysOfWeek = daysOfWeek(firstDayOfWeek = DayOfWeek.SUNDAY)

    val state = rememberCalendarState(
        startMonth = startMonth,
        endMonth = endMonth,
        firstVisibleMonth = currentMonth,
        firstDayOfWeek = firstDayOfWeek
    )

    val currentMonthFormatted = remember(state.firstVisibleMonth.yearMonth) {
        state.firstVisibleMonth.yearMonth.format(DateTimeFormatter.ofPattern("yyyy년 MM월"))
    }

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
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .padding(10.dp)
                ) {
                    DaysOfWeekTitle(daysOfWeek = daysOfWeek)
                    HorizontalCalendar(
                        state = state,
                        dayContent = {
                            Day(
                                day = it,
                                clickedDate = uiState.dateSelection,
                                onDateClick = { clickedDate -> viewModel.postIntent(HomeIntent.ChangeDate(clickedDate)) },
                            ) },
                        calendarScrollPaged = true, //차이점 잘 모르겠음
                    )
                }
                Text(
                    uiState.dateSelection.toString(),
                    modifier = Modifier,
                )
            }
        }
    }
}