package com.example.android_practice_8.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Acronym(
    val lfs: List<Lf>,
    val sf: String
)