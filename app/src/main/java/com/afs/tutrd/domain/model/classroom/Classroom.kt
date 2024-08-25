package com.afs.tutrd.domain.model.classroom

data class Classroom(
    val classroomName: String,
    val classroomProfileColor: String,
    val classroomProfileImage: String,
    val fixedCount: Int,
    val payMethod: String,
    val repetition: Repetition,
    val timetable: List<TimeTable>,
    val tuitionFee: Int,
    val tuitionFeeUnit: String,
    val tutees: List<String>,
    val tutorId: String,
    val sessions: List<String>,
    )