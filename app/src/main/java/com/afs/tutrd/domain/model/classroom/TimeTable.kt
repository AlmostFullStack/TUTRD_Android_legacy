package com.afs.tutrd.domain.model.classroom

import java.time.LocalDate

data class TimeTable(
    val startDate: LocalDate,
    val repetition: Repetition,
    val endDate: LocalDate?,
    val classHours: Float
)
