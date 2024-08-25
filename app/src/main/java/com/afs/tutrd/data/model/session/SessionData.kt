package com.afs.tutrd.data.model.session

import com.google.firebase.Timestamp
import com.google.firebase.firestore.PropertyName

data class SessionData(
    @PropertyName("attendance")
    val attendance: List<String> = emptyList(),
    @PropertyName("dateTime")
    val dateTime: Timestamp = Timestamp.now(),
    @PropertyName("elapsedTime")
    val elapsedTime: Int = 0,
    @PropertyName("homework")
    val homework: List<HomeworkData> = emptyList(),
    @PropertyName("homeworkImages")
    val homeworkImages: List<HomeworkImageData> = emptyList(),
    @get:PropertyName("isComplete")
    @set:PropertyName("isComplete")
    var isComplete: Boolean = false,
    @PropertyName("progress")
    val progress: List<String> = emptyList(),
    @PropertyName("progressImages")
    val progressImages: List<ProgressImageData> = emptyList(),
    @PropertyName("status")
    val status: Int = 0,
    @PropertyName("sessionId")
    val sessionId: String = "",
)
