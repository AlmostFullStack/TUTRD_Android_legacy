package com.afs.tutrd.presentation.shared.viewmodel

import androidx.lifecycle.ViewModel
import com.afs.tutrd.domain.model.classroom.Classroom
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SharedClassroomViewModel @Inject constructor(): ViewModel() {
    private val _classroomState: MutableStateFlow<List<Classroom>> = MutableStateFlow(listOf())
    val classroomState: StateFlow<List<Classroom>>
        get() = _classroomState.asStateFlow()


}