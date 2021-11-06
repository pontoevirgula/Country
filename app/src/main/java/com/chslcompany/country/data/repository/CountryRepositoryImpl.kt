package com.chslcompany.country.data.repository

import com.chslcompany.country.data.model.CountryResponseItem
import com.chslcompany.country.data.service.CountryAPI
import com.chslcompany.country.data.service.Requester
import retrofit2.Response

class CountryRepositoryImpl : ICountryRepository{

     override suspend fun getCountries(): Response<List<CountryResponseItem>> {
        return Requester.service.create(CountryAPI::class.java).allCountries()
    }
}