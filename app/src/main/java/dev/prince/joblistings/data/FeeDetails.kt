package dev.prince.joblistings.data

import com.google.gson.annotations.SerializedName

data class FeeDetails(
    @SerializedName("V3")
    val v3: List<Any>
)