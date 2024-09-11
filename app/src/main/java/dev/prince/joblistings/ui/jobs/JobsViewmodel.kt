package dev.prince.joblistings.ui.jobs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.prince.joblistings.data.repo.JobRepository
import dev.prince.joblistings.db.JobEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JobsViewModel @Inject constructor(
    private val repository: JobRepository
) : ViewModel() {
    private val _jobs = MutableStateFlow<List<JobEntity>>(emptyList())
    val jobs: StateFlow<List<JobEntity>> = _jobs

    init {
        fetchJobs()
        observeCachedJobs()
    }

    private fun fetchJobs() {
        viewModelScope.launch {
            try {
                repository.fetchAndCacheJobs()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun observeCachedJobs() {
        viewModelScope.launch {
            repository.getAllCachedJobs().collect { jobEntities ->
                _jobs.value = jobEntities
            }
        }
    }

    fun toggleBookmark(job: JobEntity) {
        viewModelScope.launch {
            val updatedJob = job.copy(isBookmarked = !job.isBookmarked)
            repository.updateJob(updatedJob)
        }
    }
}