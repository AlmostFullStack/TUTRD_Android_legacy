package com.afs.tutrd.data.model.session

import com.google.firebase.firestore.PropertyName

data class ProgressImageData(
    @PropertyName("description")
    val description: String = "",
    @PropertyName("image")
    val image: String = ""
)
