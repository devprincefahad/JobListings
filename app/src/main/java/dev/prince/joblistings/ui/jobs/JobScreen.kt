package dev.prince.joblistings.ui.jobs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.prince.joblistings.data.models.Result

@Destination(start = true)
@Composable
fun JobScreen(
    navigator: DestinationsNavigator,
    viewModel: JobsViewModel = hiltViewModel()
) {

    val jobs by viewModel.jobs.collectAsState()

    Column {

        LazyColumn {
            items(jobs) { job ->
                JobItem(job)
            }
        }
    }

}

@Composable
fun JobItem(job: Result) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Job Title: ${job.title}")
        Text(text = "Salary range: ${job.salaryMin} - ${job.salaryMax}")
        Text(text = "Location: ${job.jobLocationSlug}")
        Text(text = "Phone number: ${job.whatsappNo}")
    }
}
