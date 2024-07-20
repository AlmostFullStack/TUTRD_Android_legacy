package com.afs.tutrd.domain.healthCheck

interface HealthCheckRepository {
    suspend fun checkHealth(): Result<String>
}