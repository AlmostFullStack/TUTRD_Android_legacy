package com.afs.tutrd.presentation.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.afs.tutrd.common.extension.collectInLaunchedEffectWithLifecycle
import com.afs.tutrd.component.scaffold.TutrdScaffold
import com.afs.tutrd.component.topbar.HomeTopBar
import com.afs.tutrd.presentation.home.contract.HomeIntent
import com.afs.tutrd.presentation.home.contract.HomeSideEffect
import com.afs.tutrd.presentation.home.stateholder.rememberFirstMostVisibleMonth
import com.afs.tutrd.presentation.home.util.displayText
import com.afs.tutrd.presentation.home.view.bottomsheet.BottomSheetSessionList
import com.afs.tutrd.presentation.home.view.calendar.Calendar
import com.afs.tutrd.presentation.home.viewmodel.HomeViewModel
import com.afs.tutrd.theme.TutrdBackground
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import com.kizitonwose.calendar.core.yearMonth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    //calendar states
    val startMonth = remember { uiState.dateSelection.yearMonth.minusMonths(100) } // Adjust as needed
    val endMonth = remember { uiState.dateSelection.yearMonth.plusMonths(100) } // Adjust as needed
    val firstDayOfWeek = remember { firstDayOfWeekFromLocale() } // Available from the library
    val calendarState = rememberCalendarState(
        startMonth = startMonth,
        endMonth = endMonth,
        firstVisibleMonth = uiState.dateSelection.yearMonth,
        firstDayOfWeek = firstDayOfWeek
    )
    val currentMonthFormatted = rememberFirstMostVisibleMonth(state = calendarState, viewportPercent = 95f) {
        viewModel.postIntent(HomeIntent.ChangeMonth(it))
    }
    val calendarHeight = 435.dp

    //scaffold state
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val sheetPeekHeight = screenHeight - calendarHeight


    TutrdScaffold(
        topBar = {
            HomeTopBar(
                title = currentMonthFormatted.yearMonth.displayText(),
                onClickTitle = {},
                onAddSession = {}
            ) }
    ) { paddingValues ->
        BottomSheetScaffold(
            modifier = modifier
                .padding(paddingValues),
            containerColor = Color.Transparent,
            sheetContentColor = Color.Black,
            sheetContainerColor = Color.White,
            sheetShadowElevation = 20.dp,
            scaffoldState = scaffoldState,
            sheetPeekHeight = sheetPeekHeight,
            sheetContent = {
                BottomSheetSessionList(
                    screenHeight
                )
            }
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .background(TutrdBackground)
            ) {
                Calendar(
                    selectedDate = uiState.dateSelection,
                    calendarState = calendarState,
                    changeSelectedDate = { clickedDate ->
                        viewModel.postIntent(
                            HomeIntent.ChangeDate(
                                clickedDate
                            )
                        )
                    }
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