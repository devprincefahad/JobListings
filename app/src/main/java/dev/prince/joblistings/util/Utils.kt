package dev.prince.joblistings.util

import dev.prince.joblistings.ui.destinations.Destination
import dev.prince.joblistings.ui.destinations.JobDetailScreenDestination

const val BASE_URL = "https://testapi.getlokalapp.com/"

fun Destination.shouldShowBottomBar(): Boolean {

    return (this !in listOf(
        JobDetailScreenDestination
    ))
}