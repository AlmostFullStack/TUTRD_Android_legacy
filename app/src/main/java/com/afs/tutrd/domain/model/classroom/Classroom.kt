package com.afs.tutrd.domain.model.classroom

import com.afs.tutrd.domain.model.repetition.Repetition

data class Classroom(
    val id: String,
    val classroomName: String,
    val classroomProfileColor: String,
    val classroomProfileImage: String,
    val fixedCount: Int,
    val payMethod: String,
    val repetition: Repetition,
    val timetable: List<Schedule>,
    val tuitionFee: Int,
    val tuitionFeeUnit: String,
    val tutees: List<String>,
    val tutorId: String,
    val sessions: List<String>,
    )