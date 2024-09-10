package dev.prince.joblistings.ui.jobs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.prince.joblistings.ui.components.JobCardItem

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
                JobCardItem(job)
            }
        }
    }

}
