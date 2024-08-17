package com.afs.tutrd.data.model.classroom

import com.google.firebase.Timestamp
import com.google.firebase.firestore.PropertyName

data class TimetableData(
    @PropertyName("classHours")
    val classHours: Int = 0,
    @PropertyName("endDate")
    val endDate: Timestamp = Timestamp.now(),
    @PropertyName("repetition")
    val repetition: RepetitionData = RepetitionData(),
    @PropertyName("startDate")
    val startDate: Timestamp = Timestamp.now()

)
