package com.afs.tutrd.data.repository.classroom

import com.afs.tutrd.data.constant.firestore.Collection
import com.afs.tutrd.data.constant.firestore.Field
import com.afs.tutrd.data.model.classroom.Classroom
import com.afs.tutrd.di.qualifier.IoDispatcher
import com.afs.tutrd.domain.repository.classroom.ClassroomRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ClassroomRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ClassroomRepository {
    override suspend fun fetchClassroomList(tutorId: String): Result<List<Classroom>> =
        withContext(dispatcher) {
            runCatching {
                firestore.collection(Collection.CLASSROOM)
                    .whereEqualTo(Field.TUTOR_ID, tutorId)
                    .get().await().toObjects(Classroom::class.java)
            }
        }
}