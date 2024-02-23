package com.example.composepractice.repository

const val MAX_COUNTRY_NUMBER = 10

val countryCodes = setOf(
    "AF" to "Afghanistan",
    "BE" to "Belgium",
    "CX" to "Christmas Island",
    "GL" to "Greenland",
    "HR" to "Croatia",
    "JM" to "Jamaica",
    "KR" to "Korea",
    "MY" to "Malaysia",
    "NO" to "Norway",
    "UG" to "Uganda"
)

fun getRandomCountry(): Pair<String, String> =
    countryCodes.random()

