package com.example.android_practice_8.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Lf(
    val freq: Int,
    val lf: String,
    val since: Int,
    val vars: List<Var>
)