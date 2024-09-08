package com.afs.tutrd.data.model.classroom

import com.google.firebase.firestore.PropertyName

data class ClassroomData(
    @PropertyName("classroomName")
    val classroomName: String = "",
    @PropertyName("classroomProfileColor")
    val classroomProfileColor: String = "",
    @PropertyName("classroomProfileImage")
    val classroomProfileImage: String = "",
    @PropertyName("fixedCount")
    val fixedCount: Int = 0,
    @PropertyName("payMethod")
    val payMethod: String = "",
    @PropertyName("repetition")
    val repetition: RepetitionData = RepetitionData(),
    @PropertyName("timetable")
    val timetable: List<TimetableData> = emptyList(),
    @PropertyName("tuitionFee")
    val tuitionFee: Int = 0,
    @PropertyName("tuitionFeeUnit")
    val tuitionFeeUnit: String = "",
    @PropertyName("tutees")
    val tutees: List<String> = emptyList(),
    @PropertyName("tutorId")
    val tutorId: String = "",
    @PropertyName("sessions")
    val tutoring: List<String> = emptyList(),
)
