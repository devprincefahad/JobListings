package dev.prince.joblistings.ui.detail

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.prince.joblistings.R
import dev.prince.joblistings.ui.theme.poppinsFamily

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun JobDetailScreen(
    navigator: DestinationsNavigator,
    jobId: Int,
    viewModel: JobDetailViewModel = hiltViewModel()
) {

    val job by viewModel.job.collectAsState()

    LaunchedEffect(jobId) {
        viewModel.getJobById(jobId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        TopAppBar(
            windowInsets = WindowInsets(0, 0, 0, 0),
            title = { },
            navigationIcon = {
                IconButton(
                    onClick = {
                        navigator.popBackStack()
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = "Back"
                    )
                }
            },
//            actions = {
//                IconButton(
//                    onClick = {
//                        job?.let { viewModel.toggleBookmark(it) }
//                    }
//                ) {
//                    Icon(
//                        painter = if (job.isBookmarked) painterResource(id = R.drawable.ic_bookmarked)
//                        else painterResource(id = R.drawable.ic_bookmark),
//                        contentDescription = if (job!!.isBookmarked) "Remove bookmark" else "Bookmark",
//                        tint = if (job!!.isBookmarked) MaterialTheme.colorScheme.primary else Color.Gray
//                    )
//                }
//
//            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {


            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = job?.description ?: "Job Title not present",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Normal,
                    fontFamily = poppinsFamily
                )
            )
            Spacer(modifier = Modifier.height(14.dp))

//        AsyncImage(
//            model = job?.thumbUrl ?: "",
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//                .clip(shape = RoundedCornerShape(8.dp)),
//            contentScale = ContentScale.Crop
//        )

            Spacer(modifier = Modifier.height(12.dp))


            Row {
                Text(
                    text = "Job Type: ",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Normal,
                        fontFamily = poppinsFamily
                    )
                )

                Text(
                    text = job?.title ?: "",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Normal,
                        fontFamily = poppinsFamily
                    )
                )
            }


            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_salary),
                    contentDescription = "Salary Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = job?.salary ?: "No salary available",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontFamily = poppinsFamily
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = "Location Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = job?.location ?: "No Location",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontFamily = poppinsFamily
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_call),
                    contentDescription = "Phone Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = job?.phoneNum ?: "No contact",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontFamily = poppinsFamily
                    )
                )
            }
        }
    }

    BackHandler {
        navigator.popBackStack()
    }
}