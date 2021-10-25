package com.chslcompany.country.service

import com.chslcompany.country.model.CountryResponseItem
import retrofit2.Response

class CountryRepository {

    suspend fun getCountries(): Response<List<CountryResponseItem>> {
        return Requester.service.create(CountryAPI::class.java).allCountries()
    }
}