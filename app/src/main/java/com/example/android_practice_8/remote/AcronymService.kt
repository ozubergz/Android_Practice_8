package com.example.android_practice_8.remote

import com.example.android_practice_8.model.Acronym
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AcronymService {

//    http://www.nactem.ac.uk/software/acromine/dictionary.py?sf=uk

    @GET("software/acromine/dictionary.py?")
    suspend fun fetchAcronym(@Query("sf") query: String) : Response<List<Acronym>>
}