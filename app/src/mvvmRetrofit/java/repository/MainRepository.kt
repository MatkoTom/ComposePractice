package com.example.composepractice.repository

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.composepractice.networking.FlagsService
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val flagsService: FlagsService
) : MainRepository {
    override suspend fun callFlagsApi(flag: Pair<String, String>): Bitmap? {
        val response = flagsService.getFlagByCountryCode(flag.first)
        return if (response.body() != null) {
            val imageData = response.body()?.bytes()
            val bitmap = imageData?.size?.let { BitmapFactory.decodeByteArray(imageData, 0, it) }

            bitmap
        } else null
    }
}

interface MainRepository {
    suspend fun callFlagsApi(flag: Pair<String, String>): Bitmap?
}
