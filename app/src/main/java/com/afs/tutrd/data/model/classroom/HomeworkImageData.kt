package com.afs.tutrd.data.model.classroom

import com.google.firebase.firestore.PropertyName

data class HomeworkImageData(
    @PropertyName("description")
    val description: String = "",
    @PropertyName("image")
    val image: String = ""
)
