package dev.prince.joblistings.data.models

import com.google.gson.annotations.SerializedName


data class JobResponse(
    @SerializedName("results")
    val results: List<ResultResponse>
)