package com.afs.tutrd.domain.model.schedule
import com.afs.tutrd.domain.model.repetition.Repetition
import java.time.LocalDate

data class Schedule(
    val startDate: LocalDate,
    val repetition: Repetition,
    val endDate: LocalDate?,
    val classHours: Float
)
