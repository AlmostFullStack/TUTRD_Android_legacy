package com.afs.tutrd.presentation.classroom.contract

import com.afs.tutrd.common.base.UiState
import com.afs.tutrd.data.model.classroom.ClassroomData

data class ClassroomState(
    val classroomList: List<ClassroomData>
): UiState() {
    companion object {
        fun init() = ClassroomState(
            classroomList = emptyList()
        )
    }
}
