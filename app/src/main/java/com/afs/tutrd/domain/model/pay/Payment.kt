package com.afs.tutrd.domain.model.pay

import java.time.LocalDateTime

data class Payment(
    val classRoomId: String,
    val tutorId: String,
    val tuteeId: String,
    val creationDate: LocalDateTime,
    val receivedDate: LocalDateTime,
    val amount: Int,
)