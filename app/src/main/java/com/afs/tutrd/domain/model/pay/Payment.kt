package com.afs.tutrd.domain.model.pay

import java.time.LocalDateTime

data class Payment(
    val classroomId: String,
    val tutorId: String,
    val tuteeId: String,
    val creationDate: LocalDateTime,
    val receivedDate: LocalDateTime,
    val amount: Int,
)