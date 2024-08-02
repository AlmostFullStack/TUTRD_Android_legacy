package com.afs.tutrd.data.model.classroom

import com.google.firebase.firestore.PropertyName

// TODO 이름 바꾸기 (사유: 겹침)
data class Classroom(
    @PropertyName("classroomName")
    val classroomName: String = "",
    @PropertyName("classroomProfileColor")
    val classroomProfileColor: String = "",
    @PropertyName("classroomProfileImage")
    val classroomProfileImage: String = "",
    @PropertyName("fixedCount")
    val fixedCount: Int = 0,
    @PropertyName("payMethod")
    val payMethod: String = ""
    // TODO 나머지 채우기 / 근데 모델 이렇게 따로 쓸건지 질문 하기 (파이어스토어랑 주고 받는 모델 / 뷰에서 쓰는 모델)
)
