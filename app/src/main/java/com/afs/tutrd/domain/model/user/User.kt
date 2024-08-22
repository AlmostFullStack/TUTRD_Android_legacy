package com.afs.tutrd.domain.model.user

import java.time.LocalDateTime

data class User(
    val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val profileImageUrl: String,
    val introduction: String,
    val tuteeId: ArrayList<String>,
    val specialties: ArrayList<String>,
    val membership: String,
    val membershipDueDate: LocalDateTime
)