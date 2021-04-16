package com.example.android_practice_8.repositories

import com.example.android_practice_8.model.Acronym
import com.example.android_practice_8.remote.AcronymService
import retrofit2.Response
import javax.inject.Inject


class AcronymRepository @Inject constructor(
    private val acronymService: AcronymService
) {

    suspend fun fetchAcronym(query: String) : Response<List<Acronym>> {
        return acronymService.fetchAcronym(query)
    }
}