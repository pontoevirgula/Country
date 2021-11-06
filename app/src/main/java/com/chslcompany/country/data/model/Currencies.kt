package com.chslcompany.country.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Currencies(
    @SerialName("USD")
    val uSD: USD
)