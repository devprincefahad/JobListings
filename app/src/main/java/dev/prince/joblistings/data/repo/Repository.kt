package dev.prince.joblistings.data.repo

import dev.prince.joblistings.db.JobEntity
import dev.prince.joblistings.db.JobListingDao
import dev.prince.joblistings.db.toJobEntity
import dev.prince.joblistings.network.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class JobRepository @Inject constructor(
    private val jobListingDao: JobListingDao,
    private val apiService: ApiService
) {

    suspend fun fetchAndCacheJobs() {
        val jobResponse = apiService.getJobs()
        jobResponse.results.forEach { result ->
            val existingJob = jobListingDao.getJobById(result.id)
            val jobEntity = result.toJobEntity(existingJob)
            jobListingDao.insertJob(jobEntity)
        }
    }

    fun getAllCachedJobs(): Flow<List<JobEntity>> = jobListingDao.getAllJobs()

    fun getBookmarkedJobs(): Flow<List<JobEntity>> = jobListingDao.getBookmarkedJobs()

    suspend fun updateJob(job: JobEntity) {
        jobListingDao.insertJob(job)
    }
}