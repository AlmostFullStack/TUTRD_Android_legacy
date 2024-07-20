package com.afs.tutrd.data.healthCheck

import com.afs.tutrd.domain.healthCheck.HealthCheckRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.random.Random

class HealthCheckRepositoryIml @Inject constructor(

): HealthCheckRepository {
    override suspend fun checkHealth(): Result<String> = withContext(Dispatchers.IO) {
        return@withContext runCatching {
            delay(500)
            "HealthCheck num -> ${Random.nextInt(100)}"
        }
    }

}