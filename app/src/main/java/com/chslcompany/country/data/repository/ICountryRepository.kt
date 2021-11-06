package com.chslcompany.country.data.repository

import com.chslcompany.country.data.model.CountryResponseItem
import retrofit2.Response

interface ICountryRepository {
    suspend fun getCountries(): Response<List<CountryResponseItem>>
}