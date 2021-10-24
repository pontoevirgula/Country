package com.chslcompany.country.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Currencies(
    @SerialName("USD")
    val uSD: USD
)