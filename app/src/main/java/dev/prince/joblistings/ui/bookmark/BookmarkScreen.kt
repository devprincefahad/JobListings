package dev.prince.joblistings.ui.bookmark

import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
@Destination
fun BookmarkScreen(
    navigator: DestinationsNavigator,
    viewModel: BookmarkViewModel = hiltViewModel()
) {

    val bookmarkedJobs by viewModel.bookmarkedJobs.collectAsState()

    val context = LocalContext.current

    Text(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp),
        text = "Bookmarks",
        fontWeight = FontWeight.SemiBold,
        style = TextStyle(
            fontSize = 26.sp,
            fontFamily = poppinsFamily,
            color = MaterialTheme.colorScheme.primary
        )
    )

    if (bookmarkedJobs.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                text = "No bookmarks added",
                fontWeight = FontWeight.SemiBold,
                style = TextStyle(
                    fontSize = 26.sp,
                    fontFamily = poppinsFamily,
                    color = MaterialTheme.colorScheme.primary
                )
            )
        }
    } else {


        LazyColumn {

            item {

                Text(
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    text = "Bookmarks",
                    fontWeight = FontWeight.SemiBold,
                    style = TextStyle(
                        fontSize = 26.sp,
                        fontFamily = poppinsFamily,
                        color = MaterialTheme.colorScheme.primary
                    )
                )
            }

            items(
                bookmarkedJobs,
                key = { it.id }
            ) { job ->
                JobCardItem(
                    navigator = navigator,
                    job = job,
                    onBookmarkClick = { viewModel.toggleBookmark(job) }
                )
            }
        }
    }
    BackHandler {
        (context as ComponentActivity).finish()
    }
}