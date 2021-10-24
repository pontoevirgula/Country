package com.chslcompany.country.service

import com.chslcompany.country.model.CountryResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface CountryAPI {
    @GET("{version}/all")
    suspend fun allCountries(
        @Path("version")version : String = "v3.1"
    ): Response<List<CountryResponseItem>>
}

