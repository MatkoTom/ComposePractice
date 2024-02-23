package com.example.composepractice.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val service by lazy {
        val retrofit =
            Retrofit.Builder().baseUrl("https://flagsapi.com/")
                .addConverterFactory(
                    GsonConverterFactory.create()
                ).build()
        retrofit.create(FlagsService::class.java)
    }
}
