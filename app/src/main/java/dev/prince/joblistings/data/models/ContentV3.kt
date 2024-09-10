package dev.prince.joblistings.data.models

import com.google.gson.annotations.SerializedName

data class ContentV3(
    @SerializedName("V3")
    val v3: List<V3>
)