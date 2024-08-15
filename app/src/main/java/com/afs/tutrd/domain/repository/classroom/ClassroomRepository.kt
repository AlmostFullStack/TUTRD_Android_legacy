package com.afs.tutrd.domain.repository.classroom

import com.afs.tutrd.data.model.classroom.ClassroomData

interface ClassroomRepository {
    suspend fun fetchClassroomList(tutorId: String): Result<List<ClassroomData>>
}