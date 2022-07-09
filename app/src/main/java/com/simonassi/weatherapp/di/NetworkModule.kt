package com.simonassi.weatherapp.di

import com.simonassi.weatherapp.api.AccuWeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideAccuWeatherService(): AccuWeatherService {
        return AccuWeatherService.create()
    }
}