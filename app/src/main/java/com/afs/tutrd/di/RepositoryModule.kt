package com.afs.tutrd.di

import com.afs.tutrd.data.repository.classroom.ClassroomRepositoryImpl
import com.afs.tutrd.domain.repository.classroom.ClassroomRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindClassroomRepository(
        classroomRepositoryImpl: ClassroomRepositoryImpl
    ): ClassroomRepository
}