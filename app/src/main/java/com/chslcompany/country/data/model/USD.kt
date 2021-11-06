package com.chslcompany.country.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class USD(
    @SerialName("name")
    val name: String,
    @SerialName("symbol")
    val symbol: String
)