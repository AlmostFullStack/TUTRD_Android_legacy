package com.afs.tutrd.domain.model.classroom

import java.time.DayOfWeek

data class Repetition(
    val type: RepetitionType,
    val interval: Int,
    val month: Int,
    val week: Int,
    val date: Int,
    val day: DayOfWeek?
)