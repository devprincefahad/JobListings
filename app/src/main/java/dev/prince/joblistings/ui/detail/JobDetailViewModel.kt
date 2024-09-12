package dev.prince.joblistings.ui.detail

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
class JobDetailViewModel @Inject constructor(
    private val jobRepository: JobRepository
) : ViewModel() {

    private val _job = MutableStateFlow<JobEntity?>(null)
    val job: StateFlow<JobEntity?> = _job

    fun getJobById(jobId: Int) {
        viewModelScope.launch {
            _job.value = jobRepository.getJobById(jobId)
        }
    }

    fun toggleBookmark(job: JobEntity) {
        viewModelScope.launch {
            val updatedJob = job.copy(isBookmarked = !job.isBookmarked)
            jobRepository.updateJob(updatedJob)
        }
    }
}