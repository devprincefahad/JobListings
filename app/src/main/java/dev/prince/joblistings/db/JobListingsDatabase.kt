package dev.prince.joblistings.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [JobEntity::class], version = 1, exportSchema = false)
abstract class JobListingsDatabase : RoomDatabase() {
    abstract fun jobListingDao(): JobEntity
}