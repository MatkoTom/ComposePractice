package com.example.composepractice.networking

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FlagsService {
    @GET("{countryCode}/shiny/64.png")
    suspend fun getFlagByCountryCode(
        @Path("countryCode") countryCode: String
    ): Response<ResponseBody>
}
