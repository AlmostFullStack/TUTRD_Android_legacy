package com.afs.tutrd.di

import com.afs.tutrd.data.healthCheck.HealthCheckRepositoryIml
import com.afs.tutrd.domain.healthCheck.HealthCheckRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindHealthCheckRepository(
        healthCheckRepositoryIml: HealthCheckRepositoryIml
    ): HealthCheckRepository
}