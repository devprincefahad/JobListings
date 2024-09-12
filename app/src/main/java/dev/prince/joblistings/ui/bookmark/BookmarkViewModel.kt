package dev.prince.joblistings.ui.bookmark

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
class BookmarkViewModel @Inject constructor(
    private val repository: JobRepository
) : ViewModel() {
    val bookmarkedJobs = repository.getBookmarkedJobs().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun toggleBookmark(job: JobEntity) {
        viewModelScope.launch {
            val updatedJob = job.copy(isBookmarked = !job.isBookmarked)
            repository.updateJob(updatedJob)
        }
    }
}
