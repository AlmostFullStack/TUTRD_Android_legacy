package com.afs.tutrd.data.model.payment

import com.google.firebase.Timestamp
import com.google.firebase.firestore.PropertyName

data class PaymentData(
    @PropertyName("classroomId")
    val classroomId: String = "",
    @PropertyName("tutorId")
    val tutorId: String = "",
    @PropertyName("tuteeId")
    val tuteeId: String = "",
    @PropertyName("creationDate")
    val creationDate: Timestamp = Timestamp.now(),
    @PropertyName("receivedDate")
    val receivedDate: Timestamp? = Timestamp.now(),
    @PropertyName("amount")
    val amount: Int = 0,
)