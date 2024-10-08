package dev.prince.joblistings.data.models

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("id")
    val id: Int,
    @SerializedName("locale")
    val locale: String,
    @SerializedName("state")
    val state: Int
)