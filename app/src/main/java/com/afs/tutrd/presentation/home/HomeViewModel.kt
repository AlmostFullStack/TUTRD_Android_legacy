package com.afs.tutrd.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afs.tutrd.common.base.BaseViewModel
import com.afs.tutrd.domain.healthCheck.HealthCheckRepository
import com.afs.tutrd.navigation.home.screen.Home
import com.afs.tutrd.presentation.home.contract.HomeIntent
import com.afs.tutrd.presentation.home.contract.HomeSideEffect
import com.afs.tutrd.presentation.home.contract.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<HomeState, HomeIntent, HomeSideEffect>(
    initialState = HomeState.init()
) {
    override fun handleIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.ChangeDate -> { onClickDate(intent.clickedDate) }
            is HomeIntent.ChangeMonth -> {}
        }
    }
    private fun onClickDate(clickedDate: LocalDate) {
        if (uiState.value.dateSelection != clickedDate) {
            reduce { copy(dateSelection = clickedDate) }
        }
    }

}


