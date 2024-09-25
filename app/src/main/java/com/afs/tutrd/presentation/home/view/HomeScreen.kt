package com.afs.tutrd.presentation.home.view

import android.os.Handler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.afs.tutrd.common.extension.collectInLaunchedEffectWithLifecycle
import com.afs.tutrd.component.modal.BaseModalBottomSheet
import com.afs.tutrd.component.scaffold.TutrdScaffold
import com.afs.tutrd.presentation.home.contract.HomeIntent
import com.afs.tutrd.presentation.home.contract.HomeSideEffect
import com.afs.tutrd.presentation.home.stateholder.rememberFirstMostVisibleMonth
import com.afs.tutrd.presentation.home.util.displayText
import com.afs.tutrd.presentation.home.view.bottomsheet.BottomSheetSessionList
import com.afs.tutrd.presentation.home.view.calendar.Calendar
import com.afs.tutrd.presentation.home.viewmodel.HomeViewModel
import com.afs.tutrd.presentation.shared.view.addsession.AddSessionModalContents
import com.afs.tutrd.theme.TutrdBackground
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import com.kizitonwose.calendar.core.yearMonth
import kotlinx.coroutines.launch
import java.util.Timer
import kotlin.concurrent.timerTask

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToSession: () -> Unit
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

    //bottomsheet scaffold state
    val scaffoldState = rememberBottomSheetScaffoldState()
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val sheetPeekHeight = screenHeight - calendarHeight

    //coroutine scope
    val coroutineScope = rememberCoroutineScope()

    //bottomsheet modal state
    val modalBottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { it == SheetValue.Hidden || it == SheetValue.Expanded }
    )
    var showBottomSheet by remember { mutableStateOf(false) }

    TutrdScaffold(
        topBar = {
            HomeTopBar(
                title = currentMonthFormatted.yearMonth.displayText(),
                onClickTitle = {},
                onAddSession = {
                    coroutineScope.launch { modalBottomSheetState.show() }
                    showBottomSheet = true
                }
            ) }
    ) { paddingValues ->

        if(showBottomSheet) {
            BaseModalBottomSheet(
                title = "새로운 수업",
                modalBottomSheetState = modalBottomSheetState,
                onCloseModal = {
                    coroutineScope.launch { modalBottomSheetState.hide() }
                    Timer().schedule(timerTask {
                        showBottomSheet = false
                    }, 200) //ensure closing animation is fully done.
                }
            ) {
                AddSessionModalContents(
                    allowRepetition = false
                )
            }
        }

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
                    screenHeight,
                    navigateSession = { navigateToSession() }
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