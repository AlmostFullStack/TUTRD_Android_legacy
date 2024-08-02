package com.afs.tutrd.presentation.classroom

import androidx.lifecycle.viewModelScope
import com.afs.tutrd.common.base.BaseViewModel
import com.afs.tutrd.domain.repository.classroom.ClassroomRepository
import com.afs.tutrd.presentation.classroom.contract.ClassroomIntent
import com.afs.tutrd.presentation.classroom.contract.ClassroomSideEffect
import com.afs.tutrd.presentation.classroom.contract.ClassroomState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 작업하시는 브랜치에서 바꿔주세요
 *
 * */

@HiltViewModel
class ClassroomViewModel @Inject constructor(
    private val classroomRepository: ClassroomRepository
):BaseViewModel<ClassroomState, ClassroomIntent, ClassroomSideEffect>(
    initialState = ClassroomState.init()
) {
    override fun handleIntent(intent: ClassroomIntent) {
        TODO("Not yet implemented")
    }

    init {
        fetchClassRoomList() //FIXME 사용에 맞게 고치기
    }

    private fun fetchClassRoomList() = viewModelScope.launch {
        classroomRepository.fetchClassroomList("exampletutorId").onSuccess {
            reduce { copy(classroomList = it) }
        }.onFailure {
            println("실패 $it")
        }
    }
}