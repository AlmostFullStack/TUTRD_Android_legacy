package com.afs.tutrd.data.model.session

import com.google.firebase.firestore.PropertyName

data class HomeworkData(
    @PropertyName("content")
    val content: String = "",
    @get:PropertyName("isDone")
    @set:PropertyName("isDone")
    var isDone: Boolean = false
)
