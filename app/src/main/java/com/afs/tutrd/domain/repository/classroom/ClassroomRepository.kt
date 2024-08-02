package com.afs.tutrd.domain.repository.classroom

import com.afs.tutrd.data.model.classroom.Classroom

interface ClassroomRepository {
    suspend fun fetchClassroomList(tutorId: String): Result<List<Classroom>>
}