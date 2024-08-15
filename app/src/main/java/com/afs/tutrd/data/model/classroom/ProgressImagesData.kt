package com.afs.tutrd.data.model.classroom

import com.google.firebase.firestore.PropertyName

data class ProgressImagesData(
    @PropertyName("description")
    val description: String = "",
    @PropertyName("image")
    val image: String = ""
)
