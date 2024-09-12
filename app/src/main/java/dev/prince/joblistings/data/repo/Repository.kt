package dev.prince.joblistings.data.repo

import dev.prince.joblistings.db.JobEntity
import dev.prince.joblistings.db.JobListingDao
import dev.prince.joblistings.db.toJobEntity
import dev.prince.joblistings.network.ApiService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class JobRepository @Inject constructor(
    private val jobListingDao: JobListingDao,
    private val apiService: ApiService
) {

    suspend fun fetchAndCacheJobs(page: Int = 1): Int {
        delay(2000)
        val jobResponse = apiService.getJobs(page)
        jobResponse.results.forEach { result ->
            val existingJob = jobListingDao.getJobById(result.id)
            val jobEntity = result.toJobEntity(existingJob)
            jobListingDao.insertJob(jobEntity)
        }
        return if (jobResponse.results.isNotEmpty()) page + 1 else page
    }

    fun getAllCachedJobs(): Flow<List<JobEntity>> = jobListingDao.getAllJobs()

    fun getBookmarkedJobs(): Flow<List<JobEntity>> = jobListingDao.getBookmarkedJobs()

    suspend fun updateJob(job: JobEntity) {
        jobListingDao.insertJob(job)
    }
}