package dev.prince.joblistings.data.repo

import dev.prince.joblistings.data.models.JobResponse
import dev.prince.joblistings.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JobRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getJobs(): JobResponse {
        return apiService.getJobs()
    }

}