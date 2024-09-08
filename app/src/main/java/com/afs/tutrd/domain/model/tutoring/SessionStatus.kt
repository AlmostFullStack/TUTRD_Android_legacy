package com.afs.tutrd.domain.model.tutoring

enum class SessionStatus {
    ROUTINE, //시간표 상 수업
    CANCELED, //휴강처리 또는 수업시간이 변경되어 생긴 무효한 수업
    SHIFTED, //수업시간이 변경되어 생긴 유효한 수업
    EXTRA //시간표 상에 없는 추가된 수업
}