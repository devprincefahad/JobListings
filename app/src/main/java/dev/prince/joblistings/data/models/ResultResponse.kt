package dev.prince.joblistings.data.models

import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @SerializedName("advertiser")
    val advertiser: Int,
    @SerializedName("amount")
    val amount: String,
    @SerializedName("button_text")
    val buttonText: String,
    @SerializedName("city_location")
    val cityLocation: Int,
    @SerializedName("company_name")
    val companyName: String,
    @SerializedName("contact_preference")
    val contactPreference: ContactPreference,
    @SerializedName("content")
    val content: String,
    @SerializedName("contentV3")
    val contentV3: ContentV3,
    @SerializedName("created_on")
    val createdOn: String,
    @SerializedName("creatives")
    val creatives: List<Creative>,
    @SerializedName("custom_link")
    val customLink: String,
    @SerializedName("enable_lead_collection")
    val enableLeadCollection: Boolean,
    @SerializedName("experience")
    val experience: Int,
    @SerializedName("expire_on")
    val expireOn: String,
    @SerializedName("fb_shares")
    val fbShares: Int,
    @SerializedName("fee_details")
    val feeDetails: FeeDetails,
    @SerializedName("fees_charged")
    val feesCharged: Int,
    @SerializedName("fees_text")
    val feesText: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_applied")
    val isApplied: Boolean,
    @SerializedName("is_bookmarked")
    val isBookmarked: Boolean,
    @SerializedName("is_job_seeker_profile_mandatory")
    val isJobSeekerProfileMandatory: Boolean,
    @SerializedName("is_owner")
    val isOwner: Boolean,
    @SerializedName("is_premium")
    val isPremium: Boolean,
    @SerializedName("job_category")
    val jobCategory: String,
    @SerializedName("job_category_id")
    val jobCategoryId: Int,
    @SerializedName("job_hours")
    val jobHours: String,
    @SerializedName("job_location_slug")
    val jobLocationSlug: String,
    @SerializedName("job_role")
    val jobRole: String,
    @SerializedName("job_role_id")
    val jobRoleId: Int,
    @SerializedName("job_tags")
    val jobTags: List<JobTag>,
    @SerializedName("job_type")
    val jobType: Int,
    @SerializedName("locality")
    val locality: Int,
    @SerializedName("locations")
    val locations: List<Location>,
    @SerializedName("num_applications")
    val numApplications: Int,
    @SerializedName("openings_count")
    val openingsCount: Int,
    @SerializedName("other_details")
    val otherDetails: String,
    @SerializedName("premium_till")
    val premiumTill: String,
    @SerializedName("primary_details")
    val primaryDetails: PrimaryDetails,
    @SerializedName("qualification")
    val qualification: Int,
    @SerializedName("question_bank_id")
    val questionBankId: Any,
    @SerializedName("salary_max")
    val salaryMax: Int,
    @SerializedName("salary_min")
    val salaryMin: Int,
    @SerializedName("screening_retry")
    val screeningRetry: Any,
    @SerializedName("shares")
    val shares: Int,
    @SerializedName("shift_timing")
    val shiftTiming: Int,
    @SerializedName("should_show_last_contacted")
    val shouldShowLastContacted: Boolean,
    @SerializedName("status")
    val status: Int,
    @SerializedName("tags")
    val tags: List<Any>,
    @SerializedName("title")
    val title: String,
    @SerializedName("translated_content")
    val translatedContent: TranslatedContent,
    @SerializedName("type")
    val type: Int,
    @SerializedName("updated_on")
    val updatedOn: String,
    @SerializedName("videos")
    val videos: List<Any>,
    @SerializedName("views")
    val views: Int,
    @SerializedName("whatsapp_no")
    val whatsappNo: String
)