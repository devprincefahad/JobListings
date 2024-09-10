package dev.prince.joblistings.ui.jobs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.prince.joblistings.data.models.JobResponse
import dev.prince.joblistings.data.models.Result
import dev.prince.joblistings.data.repo.JobRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JobsViewModel @Inject constructor(
    private val repository: JobRepository
) : ViewModel() {

    private val _jobs = MutableStateFlow<List<Result>>(emptyList())
    val jobs: StateFlow<List<Result>> = _jobs

    init {
        fetchJobs()
    }

    private fun fetchJobs() {
        viewModelScope.launch {
            try {
                val jobs = repository.getJobs()
                _jobs.value = jobs.results
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}