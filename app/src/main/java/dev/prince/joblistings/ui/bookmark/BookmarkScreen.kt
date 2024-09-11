package dev.prince.joblistings.ui.bookmark

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.prince.joblistings.ui.components.JobCardItem

@Composable
@Destination
fun BookmarkScreen(
    navigator: DestinationsNavigator,
    viewModel: BookmarkViewModel = hiltViewModel()
) {
    val bookmarkedJobs by viewModel.bookmarkedJobs.collectAsState()

    LazyColumn {
        items(bookmarkedJobs) { job ->
            JobCardItem(
                job = job,
                onBookmarkClick = { viewModel.toggleBookmark(job) }
            )
        }
    }

}