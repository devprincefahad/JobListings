package dev.prince.joblistings.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.prince.joblistings.data.models.ResultResponse

@Entity(tableName = "jobs")
data class JobEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val salary: String,
    val phoneNum: String,
    val location: String,
    var isBookmarked: Boolean
)

fun ResultResponse.toJobEntity(existingJob: JobEntity?): JobEntity {
    return JobEntity(
        id = this.id,
        title = this.primaryDetails?.jobType ?: "Unknown Job Type",
        description = this.title ?: "No description available",
        salary = this.primaryDetails?.salary ?: "Not disclosed",
        phoneNum = this.whatsappNo ?: "No contact available",
        location = this.primaryDetails?.place ?: "Unknown location",
        isBookmarked = existingJob?.isBookmarked ?: false
    )
}