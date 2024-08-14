package com.afs.tutrd.domain.model.tutoring

import java.time.LocalDateTime

data class Tutoring (
    val tutoringId: String,
    val classRoomId: String,
    val dateTime: LocalDateTime,
    val elapsedTime: Float,
    val progress: ArrayList<String>,
    val homework: ArrayList<Homework>,
    val attendance: ArrayList<String>,
    val status: TutoringStatus,
    val isComplete: Boolean,
    val progressImages: ArrayList<ProgressImage>,
    val homeworkImages: ArrayList<HomeworkImage>
)