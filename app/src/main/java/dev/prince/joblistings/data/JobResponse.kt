package dev.prince.joblistings.data

import com.google.gson.annotations.SerializedName


data class JobResponse(
    @SerializedName("results")
    val results: List<Result>
)