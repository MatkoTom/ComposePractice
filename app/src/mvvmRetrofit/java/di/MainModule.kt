package com.example.composepractice.di

import com.example.composepractice.networking.FlagsService
import com.example.composepractice.repository.MainRepository
import com.example.composepractice.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideFlagService(): FlagsService {
        return Retrofit.Builder()
            .baseUrl("https://flagsapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FlagsService::class.java)
    }

    @Provides
    @Singleton
    fun provideMainRepository(service: FlagsService): MainRepository {
        return MainRepositoryImpl(flagsService = service)
    }
}
