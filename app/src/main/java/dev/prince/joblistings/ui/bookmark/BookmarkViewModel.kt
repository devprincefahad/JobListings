package dev.prince.joblistings.ui.bookmark

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
class BookmarkViewModel @Inject constructor(
    private val repository: JobRepository
) : ViewModel() {
    private val _bookmarkedJobs = MutableStateFlow<List<JobEntity>>(emptyList())
    val bookmarkedJobs: StateFlow<List<JobEntity>> = _bookmarkedJobs

    init {
        observeBookmarkedJobs()
    }

    private fun observeBookmarkedJobs() {
        viewModelScope.launch {
            repository.getBookmarkedJobs().collect { bookmarkedJobEntities ->
                _bookmarkedJobs.value = bookmarkedJobEntities
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
