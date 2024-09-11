package dev.prince.joblistings.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface JobListingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJob(job: JobEntity)

    @Query("SELECT * FROM jobs WHERE id = :jobId LIMIT 1")
    suspend fun getJobById(jobId: Int): JobEntity?

    @Query("SELECT * FROM jobs")
    fun getAllJobs(): Flow<List<JobEntity>>

    @Query("SELECT * FROM jobs WHERE isBookmarked = 1")
    fun getBookmarkedJobs(): Flow<List<JobEntity>>
}