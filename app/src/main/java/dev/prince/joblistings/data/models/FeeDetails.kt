package dev.prince.joblistings.data.models

import com.google.gson.annotations.SerializedName

data class FeeDetails(
    @SerializedName("V3")
    val v3: List<Any>
)