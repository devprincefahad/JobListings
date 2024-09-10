package dev.prince.joblistings.ui.components.bottomnav

import androidx.annotation.StringRes
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
import dev.prince.joblistings.R
import dev.prince.joblistings.ui.destinations.BookmarkScreenDestination
import dev.prince.joblistings.ui.destinations.JobScreenDestination

enum class BottomBarDestination(
    val direction: DirectionDestinationSpec,
    val icon: Int,
    @StringRes val label: Int
) {
    Jobs(JobScreenDestination, R.drawable.ic_work, R.string.jobs),
    Bookmarks(BookmarkScreenDestination, R.drawable.ic_bookmark, R.string.bookmarks)
}