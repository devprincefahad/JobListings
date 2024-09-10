package dev.prince.joblistings.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.prince.joblistings.data.repo.JobRepository
import dev.prince.joblistings.db.JobListingsDatabase
import dev.prince.joblistings.network.ApiService
import dev.prince.joblistings.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideJobRepository(apiService: ApiService): JobRepository {
        return JobRepository(apiService)
    }

    @Provides
    @Singleton
    fun provideRoomInstance(@ApplicationContext context: Context) = Room.databaseBuilder(
        context = context,
        klass = JobListingsDatabase::class.java,
        name = "job_listings_database"
    ).build()

    @Singleton
    @Provides
    fun provideTaskDao(db: JobListingsDatabase) = db.jobListingDao()

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

}