package com.afs.tutrd.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afs.tutrd.domain.healthCheck.HealthCheckRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val healthCheckRepository: HealthCheckRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(HomeState())
    val uiState = _uiState.asStateFlow()

    fun healthCheck() = viewModelScope.launch {
        healthCheckRepository.checkHealth().onSuccess {
            _uiState.update { state ->
                state.copy(healthCheck = it)
            }
        }
    }
}

data class HomeState(
    val healthCheck: String = ""
)
