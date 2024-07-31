package com.afs.tutrd.domain.model.classroom

import com.afs.tutrd.domain.model.schedule.Schedule
import com.afs.tutrd.domain.model.tutoring.Tutoring

data class Classroom(
    val tutorId: String,
    val tutees: ArrayList<String>,
    val tutorings: ArrayList<Tutoring>,
    val timetable: ArrayList<Schedule>
)