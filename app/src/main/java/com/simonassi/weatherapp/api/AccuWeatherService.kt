package com.simonassi.weatherapp.api

import com.simonassi.weatherapp.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AccuWeatherService {

    companion object {
        private const val BASE_URL = BuildConfig.BASE_URL

        fun create(): AccuWeatherService {

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AccuWeatherService::class.java)
        }
    }
}