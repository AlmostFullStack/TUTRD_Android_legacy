package com.afs.tutrd.domain.manager

import androidx.compose.ui.graphics.Color
import com.afs.tutrd.domain.model.classroom.Classroom

object ClassroomManager {
    val classrooms: List<Classroom> = listOf()

    fun getClassroomProfileColor(classroomId: String): Color {
        return Color.Red
    }
}