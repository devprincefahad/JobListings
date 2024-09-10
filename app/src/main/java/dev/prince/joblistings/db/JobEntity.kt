package dev.prince.joblistings.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jobs")
data class JobEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String? = null,
    val description: String? = null,
    val salary: String? = null,
    val phoneNum: String? = null,
    val location: String? = null,
    val isBookmarked: Boolean = false
)