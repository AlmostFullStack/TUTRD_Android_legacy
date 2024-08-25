package com.afs.tutrd.data.model.user

import com.google.firebase.Timestamp
import com.google.firebase.firestore.PropertyName

data class UserData(
    @PropertyName("id")
    val id: String = "",
    @PropertyName("name")
    val name: String = "",
    @PropertyName("email")
    val email: String = "",
    @PropertyName("phone")
    val phone: String = "",
    @PropertyName("profileImageUrl")
    val profileImageUrl: String = "",
    @PropertyName("introduction")
    val introduction: String = "",
    @PropertyName("tuteeId")
    val tuteeId: List<String> = listOf(),
    @PropertyName("specialties")
    val specialties: List<String> = listOf(),
    @PropertyName("membership")
    val membership: String = "",
    @PropertyName("membershipDueDate")
    val membershipDueDate: Timestamp = Timestamp.now(),
    )