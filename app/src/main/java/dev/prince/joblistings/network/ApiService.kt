package dev.prince.joblistings.network

import dev.prince.joblistings.data.models.JobResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("common/jobs")
    suspend fun getJobs(
        @Query("page") page: Int
    ): JobResponse

}