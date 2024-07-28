package com.afs.tutrd.domain.model.repetition

import java.time.DayOfWeek

data class Repetition(
    val type: RepetitionType,
    val interval: Int,
    val month: Int,
    val week: Int,
    val date: Int,
    val day: DayOfWeek?
)