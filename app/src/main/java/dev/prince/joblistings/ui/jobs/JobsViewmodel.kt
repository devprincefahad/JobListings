package dev.prince.joblistings.ui.jobs

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.prince.joblistings.data.repo.JobRepository
import dev.prince.joblistings.db.JobEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JobsViewModel @Inject constructor(
    private val repository: JobRepository
) : ViewModel() {
    private var currentPage = 1
    val jobs: StateFlow<List<JobEntity>> = repository.getAllCachedJobs().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )
    var loading by mutableStateOf(false)

    fun fetchJobs() {
        viewModelScope.launch {
            loading = true
            try {
                currentPage = repository.fetchAndCacheJobs(currentPage)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                loading = false
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