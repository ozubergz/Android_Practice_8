package com.example.android_practice_8.repositories

import android.util.Log
import com.example.android_practice_8.model.Acronym
import com.example.android_practice_8.model.Lf
import com.example.android_practice_8.remote.AcronymService
import retrofit2.Response
import javax.inject.Inject


class AcronymRepository @Inject constructor(
    private val acronymService: AcronymService
) {

    suspend fun fetchAcronym(query: String) : List<Lf>? {
       return acronymService.fetchAcronym(query).body()?.firstOrNull()?.lfs
//        return try {
//            acronymService.fetchAcronym(query).body()
//        } catch (e: Exception) {
//            Log.d("AcronymRepository", "fetchAcronym: ${e.localizedMessage}")
//        }
    }
}