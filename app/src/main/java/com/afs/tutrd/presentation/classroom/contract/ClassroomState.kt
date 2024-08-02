package com.afs.tutrd.presentation.classroom.contract

import com.afs.tutrd.common.base.UiState
import com.afs.tutrd.data.model.classroom.Classroom

data class ClassroomState(
    val classroomList: List<Classroom>
): UiState() {
    companion object {
        fun init() = ClassroomState(
            classroomList = emptyList()
        )
    }
}
