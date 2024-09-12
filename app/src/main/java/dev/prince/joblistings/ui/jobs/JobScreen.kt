package dev.prince.joblistings.ui.jobs

import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.prince.joblistings.ui.components.JobCardItem
import dev.prince.joblistings.ui.theme.poppinsFamily

@Destination(start = true)
@Composable
fun JobScreen(
    navigator: DestinationsNavigator,
    viewModel: JobsViewModel = hiltViewModel()
) {

    val jobs by viewModel.jobs.collectAsState()

    val context = LocalContext.current

    if (viewModel.loading && jobs.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(48.dp)
            )
        }
    } else {
        LazyColumn {

            item {

                Text(
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    text = "Jobs",
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        fontSize = 26.sp,
                        fontFamily = poppinsFamily,
                        color = MaterialTheme.colorScheme.primary
                    )
                )
            }

            items(
                jobs,
                key = { job -> job.id }
            ) { job ->
                JobCardItem(
                    navigator = navigator,
                    job = job,
                    onBookmarkClick = { viewModel.toggleBookmark(job) }
                )
            }
            if (viewModel.loading.not()) item {
                LaunchedEffect(Unit) {
                    viewModel.fetchJobs()
                }
            } else {
                item {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(16.dp)
                                .size(32.dp)
                        )
                    }
                }
            }
        }
    }

    BackHandler {
        (context as ComponentActivity).finish()
    }
}
