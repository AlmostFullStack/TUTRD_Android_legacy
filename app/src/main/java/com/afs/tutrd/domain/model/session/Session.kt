package com.afs.tutrd.domain.model.session

import com.afs.tutrd.domain.model.classroom.Tutee
import java.time.LocalDateTime

data class Session (
    val tutoringId: String,
    val classroomId: String,
    val classroomName: String,
    val dateTime: LocalDateTime,
    val elapsedTime: Float,
    val progress: ArrayList<String>,
    val homework: ArrayList<Homework>,
    val attendance: ArrayList<Tutee>,
    val status: SessionStatus,
    val isComplete: Boolean,
    val progressImages: ArrayList<ProgressImage>,
    val homeworkImages: ArrayList<HomeworkImage>,
    val isHomeworkDone: Boolean,
)