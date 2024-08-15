package com.afs.tutrd.data.model.classroom

import com.google.firebase.firestore.PropertyName

data class RepetitionData(
    @PropertyName("date")
    val date: Int = 0,
    @PropertyName("day")
    val day: String = "",
    @PropertyName("interval")
    val interval: Int = 0,
    @PropertyName("month")
    val month: Int = 0,
    @PropertyName("type")
    val type: Int = 0,
    @PropertyName("week")
    val week: Int = 0,
)
