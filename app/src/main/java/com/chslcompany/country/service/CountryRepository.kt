package com.chslcompany.country.service

import com.chslcompany.country.model.CountryResponseItem
import com.chslcompany.country.service.ApiService
import retrofit2.Response

class CountryRepository {

    suspend fun getCountries(): Response<List<CountryResponseItem>> = ApiService.services.allCountries()
}