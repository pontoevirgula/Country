package com.chslcompany.country.service

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Requester {

    private const val URL = "https://restcountries.com/"

    private val gson = GsonBuilder().setLenient().create()

    val service: Retrofit
    get(){
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}